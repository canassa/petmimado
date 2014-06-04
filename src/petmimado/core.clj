(ns petmimado.core
  (:require [petmimado.pages :as pages]
            [stasis.core :as stasis]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]))


(defn get-assets []
  (assets/load-assets "public" [#"\.(png|css|js)$"]))

(def pages {"/index.html" (pages/base pages/home "homepage")
            "/contact" (pages/base pages/contact-us "contentpage")})

(def app (-> (stasis/serve-pages pages)
             (optimus/wrap get-assets optimizations/none serve-live-assets)))
