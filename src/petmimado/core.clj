(ns petmimado.core
  (:require [petmimado.pages :as pages]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]))


(defn get-assets []
  (assets/load-assets "public" [#"\.(png|css|js)$"]))

(defn get-pages []
  {"/index.html" (pages/base pages/home "homepage")
   "/contact" (pages/base pages/contact-us "contentpage")
   "/sobre" (pages/base pages/about "contentpage")
   "/tosa" (pages/base (pages/services-single {:title "Tosa"}) "contentpage")
   "/banho" (pages/base (pages/services-single {:title "Banho"}) "contentpage")
   "/estetica" (pages/base (pages/services-single {:title "Estética"}) "contentpage")})

(def app (-> (stasis/serve-pages get-pages)
             (optimus/wrap get-assets optimizations/none serve-live-assets)))
