(ns petmimado.pages
  (:require [petmimado.text :refer [text]]
            [petmimado.urls :refer [urls]]
            [hiccup.page :refer [html5]]
            [hiccup.form :refer [form-to submit-button]]))

(def services
  [{:key :gromming
    :url (:gromming urls)
    :title (:gromming text)
    :short-description (:gromming-short-description text)
    :icon-class "kennel-img"}

   {:key :bath
    :url (:bath urls)
    :title (:bath text)
    :short-description (:bath-short-description text)
    :icon-class "kennel-img"}

   {:key :aesthetics
    :url (:aesthetics urls)
    :title (:aesthetics text)
    :short-description (:aesthetics-short-description text)
    :icon-class "kennel-img"}

   {:key :rabbits
    :url (:rabbits urls)
    :title (:rabbits text)
    :short-description (:rabbits-short-description text)
    :icon-class "kennel-img"}

   {:key :ferrets
    :url (:ferrets urls)
    :title (:ferrets text)
    :short-description (:ferrets-short-description text)
    :icon-class "kennel-img"}

   {:key :guinea-pig
    :url (:guinea-pig urls)
    :title (:guinea-pig text)
    :short-description (:guinea-pig-short-description text)
    :icon-class "kennel-img"}])

(defn navbar [& args]
  (let [nav-class (if (= (first args) :white)
                    "navbar navbar-default navbar-fixed-top inner-pages affix"
                    "navbar navbar-default navbar-fixed-top")]

    [:div {:class nav-class :role "navigation"}
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
         [:a {:href (:home urls) :title "Home"} [:span {:data-hover "Home"} "Home"]]]
        [:li
         [:a {:href "/" :title "Preços"} [:span {:data-hover "Preços"} "Preços"]]]
        [:li
         [:a {:href (:about urls) :title "Sobre nós"} [:span {:data-hover "Sobre nós"} "Sobre nós"]]]
        [:li.dropdown
         [:a.dropdown-toggle {:href "#" :data-toggle "dropdown"}
          [:span {:data-hover "Serviços"} "Serviços"] [:b.caret]]
         [:ul.dropdown-menu
          (for [{url :url title :title} services]
            [:li
             [:a {:href url :title title} title]])]]
        [:li
         [:a {:href (:contact urls) :title "Contato"} [:span {:data-hover "Contato"} "Contato"]]]]]]]))

(def footer
  [:div.footer
    [:div.container
     [:div.row
      [:div.col-md-3
       [:h6 "Um pouco sobre nós"]
       [:p [:strong "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat."]]
       [:p "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam."]]
      [:div.col-md-3.blog
       [:h6 "Blog"]
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
       [:h6 "Mantenha contato"]
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
       [:p "&copy; Copyright 2014. All rights reserved." [:a {:href "#" :title ""} "PetMimado"]]]]]])

(defn base [content page]
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
   [:body {:class page}
    content
    footer
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery.caroufredsel/6.2.1/jquery.carouFredSel.packed.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/stellar.js/0.6.2/jquery.stellar.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.0.3a/ekko-lightbox.min.js"}]
    ;; [:script {:src "//cdnjs.cloudflare.com/ajax/libs/gmaps.js/0.4.12/gmaps.min.js"}]
    [:script {:src "js/custom.js"}]]))

(defn saiba-mais
  ([] (saiba-mais "btn-lg"))
  ([klass]
    (form-to [:get "index.html"]
      (submit-button {:class (str "btn btn-default " klass)} "Saiba mais"))))

(def contact-us
  (list
   (navbar :white)
   ;; Contact
   [:div.container
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Contato"]]
      [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum."]]]]

   ;; Map
   [:div#map
    [:iframe {:frameborder 0 :style "border:0" :src "https://www.google.com/maps/embed/v1/view?zoom=16&center=-23.6110%2C-46.6834&key=AIzaSyDw51lp1J650cIo5QNqU6MfbuWESrYnVBg"}]]

   ;; Content
   [:div.container.content
    [:div.row
     [:div.col-md-9
      [:form#contact_form {:role "form"}
       [:div.form-group
        [:label {:for "InputName"} "Seu nome"]
        [:input#InputName.form-control {:type "text" :placeholder "Seu nome"}]]
       [:div.form-group
        [:label {:for "InputEmail"} "Seu email"]
        [:input#InputEmail.form-control {:type "email" :placeholder "Seu email"}]]
       [:div.form-group
        [:label {:for "Message"} "Sua mensagem"]
        [:textarea#Message.form-control {:placeholder "Sua mensagem" :rows 8}]]
       [:button.btn.btn-default.btn-green {:type "submit" } "Enviar"]]]
     [:div.col-md-3
      [:ul.contact-info
       [:li.telephone "(11) 2628-7129"]
       [:li.address "R. Califórnia 693 São Paulo - SP"]
       [:li.mail "contato@petmimado.com"]]]]]))

(defn services-single [{:keys [title content]}]
  (list
   (navbar :white)
   [:div.container
    [:div.row.services-single
     [:div.col-md-6
      [:img {:src "images/dog-walking.png" :alt "Dog walking"}]]
     [:div.col-md-6
      [:h2 title]
      (map (fn [p] [:p p]) content)
      [:div.hours
       [:div
        [:p.day [:strong "Segunda à Sexta"]]
        [:p.time [:strong "09:00 - 18:00"]]]
       [:div
        [:p.day [:strong "Sábado e Domingo"]]
        [:p.time [:strong "11:00 - 18:00"]]]
       ]]]]

   ;; Prices
   [:div.prices.services {:data-stellar-background-ratio ".3"}
    [:div.container
     [:div.row
      [:div.col-md-4.costs
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:img {:src "images/small-dog.png" :alt (:small-dog text)}]
        [:h4 (:small-dog text)]
        [:p "Tosa máquina - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa tesoura - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa padrão ou criativa - " [:span.per-night "R$ 12,00"]]
        [:form {:method "get"}
         [:button {:type "submit" :class "btn btn-default btn-green"} "Agende agora"]]]]

      [:div.col-md-4.costs
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:img {:src "images/medium-dog.png" :alt (:medium-dog text)}]
        [:h4 (:medium-dog text)]
        [:p "Tosa máquina - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa tesoura - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa padrão ou criativa - " [:span.per-night "R$ 12,00"]]
        [:form {:method "get"}
         [:button {:type "submit" :class "btn btn-default btn-green"} "Agende agora"]]]]

      [:div.col-md-4.costs
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:img {:src "images/large-dog.png" :alt (:large-dog text)}]
        [:h4 (:large-dog text)]
        [:p "Tosa máquina - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa tesoura - " [:span.per-night "R$ 12,00"]]
        [:p "Tosa padrão ou criativa - " [:span.per-night "R$ 12,00"]]
        [:form {:method "get"}
         [:button {:type "submit" :class "btn btn-default btn-green"} "Agende agora"]]]]

      ]]]))


(def about
  (list
   (navbar :white)
   [:div.container
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Sobre nós"]]
      [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum."]]]]
   [:div.staff {:data-stellar-background-ratio ".3"}
    [:div.container
     [:div.row
      [:div.col-md-3.col-md-offset-2.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "#"}]
         [:a.facebook {:href "#"}]
         [:img {:src "images/profile2.png" :alt ""}]]
        [:h4 "Maria Claudia"]
        [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram."]]]
      [:div.col-md-3.member.col-md-offset-1.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "#"}]
         [:a.facebook {:href "#"}]
         [:img {:src "images/profile3.png" :alt ""}]]
        [:h4 "Cesar Canassa"]
        [:p "Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram."]]]]]]
   [:div.container.content
    [:div.row
     [:div.col-md-6
      [:h3 [:span "Sobre o nosso Banho & Tosa"]]
      [:p "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."]
      [:p "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem."]]
     [:div.col-md-6
      [:h3 [:span "Nossa missão"]]
      [:p "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."]
      [:p "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem."]]]]))

(def home
  (list
  (navbar)
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
      [:h2 (:home-title-1 text)]
      [:p (:home-subtitle-1 text)]
      (saiba-mais)]]
    [:div.item
     [:img {:src "images/3.png" :alt ""}]
     [:div.carousel-caption
      [:h2 (:home-title-2 text)]
      [:p (:home-subtitle-2 text)]
      (saiba-mais)]]]

   ;; Controls
   [:a.left.carousel-control {:href "#home_carousel" :data-slide "prev"}
    [:span.glyphicon.glyphicon-chevron-left]]
   [:a.right.carousel-control {:href "#home_carousel" :data-slide "next"}
    [:span.glyphicon.glyphicon-chevron-right]]]

   ;; Services
   [:div.container
    (map #(vector :div.row %)
         (partition 3
                    (map (fn [{:keys [icon-class url title short-description]}]
                           [:div.col-md-4.col3
                            [:a.roundal {:class icon-class :href url :title title}]
                            [:h3 title]
                            [:p short-description]
                            (saiba-mais "btn-green")]) services)))
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span (:our-customers text)]]
      [:p (:our-customers-description text)]]]]

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
          [:p (first (:testimonials text))]]
         (map (fn [c]
                [:div.item
                 [:p c]])
              (rest (:testimonials text)))]]]]]]))
