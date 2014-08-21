(ns petmimado.core
  (:require [petmimado.pages :as pages]
            [petmimado.urls :refer [urls]]
            [petmimado.text :refer [text]]
            [petmimado.services :as services]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.export]
            [optimus.strategies :refer [serve-live-assets]]
            [optimus-img-transform.core :refer [transform-images]]))

(defn get-assets []
  (concat
    (assets/load-bundle "public" "main.css" ["/css/style.css"])
    (assets/load-bundle "public" "main.js" ["/js/custom.js"])
    (assets/load-assets "public" [#"\.(png|css|js|jpg)$"])))

(defn get-pages []
  {"/" #(pages/base % pages/home {:class "homepage"})
   (:contact urls) #(pages/base % pages/contact-us {:class "contentpage"})
   (:about urls) #(pages/base % pages/about {:class "contentpage"})
   (:plans urls) #(pages/base % (partial pages/services-single services/plans) {:class "contentpage"})
   (:bath-and-gromming urls) #(pages/base % (partial pages/services-single services/bath-and-gromming) {:class "contentpage"})
   (:aesthetics urls) #(pages/base % (partial pages/services-single services/aesthetics) {:class "contentpage"})
   (:exotic urls) #(pages/base % (partial pages/services-single services/exotic) {:class "contentpage"})
   (:training urls) #(pages/base % (partial pages/services-single services/training) {:class "contentpage"})})

(defn optimize [assets options]
  (-> assets
      (transform-images {:regexp #"/images/bw/.*\.jpg"
                         :quality 0.7
                         :progressive true})
      (transform-images {:regexp #"/images/masthead/.*\.jpg"
                         :quality 0.7
                         :progressive true})
      (optimizations/all options)))

(defn export []
  (let [assets (optimize (get-assets) {})
        pages (get-pages)
        target-dir "build"]
    (stasis/empty-directory! target-dir)
    (optimus.export/save-assets assets target-dir)
    (stasis/export-pages pages target-dir {:optimus-assets assets})))

(def app
  (->
    (stasis/serve-pages get-pages)
    (optimus/wrap
      ;; The function that loads the assets
      get-assets
      ;; The optimization function
      optimize
      ;; The strategy
      serve-live-assets)))
