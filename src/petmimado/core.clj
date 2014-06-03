(ns petmimado.core
  (:require [stasis.core :as stasis]
            [hiccup.page :refer [html5]]
            [hiccup.form :refer [form-to submit-button]]
            [optimus.prime :as optimus]
            [optimus.assets :as assets]
            [optimus.optimizations :as optimizations]
            [optimus.strategies :refer [serve-live-assets]]))


(defn get-assets []
  (assets/load-assets "public" [#"\.(png|css|js)$"]))


(defn base [content]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "PetMimado | Tosa, Grooming"]
    [:link {:rel "stylesheet" :href "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/css/bootstrap.min.css"}]
    [:link {:rel "stylesheet" :href "css/style.css"}]
    [:link {:rel "stylesheet" :href "http://fonts.googleapis.com/css?family=Cabin:400,500,600,700,400italic,500italic,600italic,700italic"}]
    [:link {:rel "stylesheet" :href "http://fonts.googleapis.com/css?family=Lato:300,400,700,900,400italic,700italic,900italic"}]]
   [:body.homepage
    content
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery.caroufredsel/6.2.1/jquery.carouFredSel.packed.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/stellar.js/0.6.2/jquery.stellar.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.0.3a/ekko-lightbox.min.js"}]
    [:script {:src "js/custom.js"}]]))

(defn saiba-mais
  ([] (saiba-mais "btn-lg"))
  ([klass]
    (form-to [:get "index.html"]
      (submit-button {:class (str "btn btn-default " klass)} "Saiba mais"))))

(def home
  (list
  [:div {:class "navbar navbar-default navbar-fixed-top" :role "navigation"}
   [:div.container
    [:div.navbar-header
     [:button.navbar-toggle {:type "button" :data-toggle "collapsed" :data-target ".navbar-collapse"}
      [:span.sr-only "Toogle navigation"]
      [:span.icon-bar]
      [:span.icon-bar]
      [:span.icon-bar]]
     [:h1
      [:a.navbar-brand {:href "/"}
       [:strong "Pet"] "Mimado" [:br]
       [:span {:data-hover "Grooming"} "Grooming"]]]]
    [:div.navbar-collapse.collapse
     [:ul.nav.navbar-nav
      [:li.active
       [:a {:href "/" :title "Home"} [:span {:data-hover "Home"} "Home"]]]
      [:li
       [:a {:href "/" :title "Preços"} [:span {:data-hover "Preços"} "Preços"]]]
      [:li
       [:a {:href "/" :title "Sobre nós"} [:span {:data-hover "Sobre nós"} "Sobre nós"]]]
      [:li.dropdown
       [:a.dropdown-toggle {:href "services.html" :data-toggle "dropdown"}
        [:span {:data-hover "Serviços"} "Serviços"] [:b.caret]]
       [:ul.dropdown-menu
        [:li
         [:a {:href "a.html" :title "Adoption"} "Adoption"]]
        [:li
         [:a {:href "a.html" :title "Adoption"} "Adoption"]]
        [:li
         [:a {:href "a.html" :title "Adoption"} "Adoption"]]
        [:li
         [:a {:href "a.html" :title "Adoption"} "Adoption"]]]]
      [:li
       [:a {:href "/" :title "Contato"} [:span {:data-hover "Contato"} "Contato"]]]]]]]

  ;; Slider
  [:div#home_carousel {:class "carousel slide" :data-ride "carousel"}
   [:ol.carousel-indicators
    [:li.active {:data-target "#home_carousel" :data-slide-to "0"}]
    [:li {:data-target "#home_carousel" :data-slide-to "1"}]]

   ;; Wrapper for slides
   [:div.carousel-inner
    [:div.item.active
     [:img {:src "images/2.png" :alt ""}]
     [:div.carousel-caption
      [:h2 "A melhor tosa do Brasil"]
      [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]
      (saiba-mais)]]
    [:div.item
     [:img {:src "images/3.png" :alt ""}]
     [:div.carousel-caption
      [:h2 "Serviço personalizado"]
      [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]
      (saiba-mais)]]]

   ;; Controls
   [:a.left.carousel-control {:href "#home_carousel" :data-slide "prev"}
    [:span.glyphicon.glyphicon-chevron-left]]
   [:a.right.carousel-control {:href "#home_carousel" :data-slide "next"}
    [:span.glyphicon.glyphicon-chevron-right]]]

   ;; Services
   [:div.container
    [:div.row

     [:div.col-md-4.col3
      [:a#kennel.roundal {:href "services-single.html" :title "Tosa"}]
      [:h3 "Tosa"]
      [:p "Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. Humanitatis per seacula quarta decima et quinta decima."]
      (saiba-mais "btn-green")]

     [:div.col-md-4.col3
      [:a#grooming.roundal {:href "services-single.html" :title "Banho"}]
      [:h3 "Banho"]
      [:p "Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. Humanitatis per seacula quarta decima et quinta decima."]
      (saiba-mais "btn-green")]

     [:div.col-md-4.col3
      [:a#adoption.roundal {:href "services-single.html" :title "Estética"}]
      [:h3 "Estética"]
      [:p "Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. Humanitatis per seacula quarta decima et quinta decima."]
      (saiba-mais "btn-green")]]

    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Nossos clientes satisfeitos"]]
      [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum."]]]]

   ;; Carousel
   [:div#c-carousel
    [:div#Wrapper
     [:div#carousel
      [:div
       [:a.lightbox {:href "images/dog-1.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-1.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "images/dog-2.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-2.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "images/dog-3.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-3.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "images/dog-1.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-1.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "images/dog-2.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-2.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "images/dog-3.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "images/dog-3.png" :alt "Dog"}]]]]
     [:div#pager.pager]]]

   ;; Testimonials
   [:div.testimonials {:data-stellar-background-ratio "0.6"}
    [:div.container
     [:div.row
      [:div.col-md-12.centered
       [:div#home_testimonial.carousel.slide {:data-ride "carousel"}
        [:ol.carousel-indicators
         [:li.active {:data-target "#home_testimonial" :data-slide-to "0"}]
         [:li {:data-target "#home_testimonial" :data-slide-to "1"}]
         [:li {:data-target "#home_testimonial" :data-slide-to "2"}]
         [:li {:data-target "#home_testimonial" :data-slide-to "3"}]]
        [:div.carousel-inner
         [:div.item.active
          [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]]
         [:div.item
          [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]]
         [:div.item
          [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]]
         [:div.item
          [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum."]]]]]]]]

   ;; Footer
   [:div.footer
    [:div.container
     [:div.row
      [:div.col-md-3
       [:h6 "A little about us"]
       [:p [:strong "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat."]]
       [:p "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam."]]
      [:div.col-md-3.blog
       [:h6 "Freshly blogged"]
       [:p.title [:a {:href "#" :title ""} "Eodem modo typi, qui nunc nobis"]]
       [:p "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam."]
       [:p.title [:a {:href "#" :title ""} "Read this post&hellip;"]]]
      [:div.col-md-3
       [:h6 "Você pode precisar disso"]
       [:ul
        [:li [:a {:href "#" :title ""} "Home"]]
        [:li [:a {:href "#" :title ""} "Contato"]]
        [:li [:a {:href "#" :title ""} "FAQ"]]
        [:li [:a {:href "#" :title ""} "Termos e Condições"]]
        [:li [:a {:href "#" :title ""} "Política de Privacidade"]]]]
      [:div.col-md-3.contact-info
       [:h6 "Keep in touch"]
       [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum."]
       [:p.social
        [:a.facebook {:href "#"}]
        [:a.pinterest {:href "#"}]
        [:a.twitter {:href "#"}]]
       [:p.c-details
        [:span "Mail"] [:a {:href "#"} "info@petcare.com"] [:br]
        [:span "Tel"] "0203 000 444"]]]
     [:div.row
      [:div.col-md-12.copyright
       [:p "&copy; Copyright 2014. All rights reserved." [:a {:href "#" :title ""} "PetMimado"]]]]]]))


(def pages {"/index.html" (base home)})

(def app (-> (stasis/serve-pages pages)
             (optimus/wrap get-assets optimizations/none serve-live-assets)))
