(ns petmimado.core
  (:require [petmimado.pages :as pages]
            [petmimado.urls :refer [urls]]
            [petmimado.text :refer [text]]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]))


(defn get-assets []
  (assets/load-assets "public" [#"\.(png|css|js)$"]))

(defn get-pages []
  (merge
   {"/index.html" (pages/base pages/home "homepage")
    (:contact urls) (pages/base pages/contact-us "contentpage")
    (:about urls) (pages/base pages/about "contentpage")}

   (into {}
         (map (fn [{:keys [key title description]}]
                [(key urls)
                 (pages/base
                  (pages/services-single
                   {:title title
                    :content description}) "contentpage")])
              pages/services))))

(def app (-> (stasis/serve-pages get-pages)
             (optimus/wrap get-assets optimizations/none serve-live-assets)))
