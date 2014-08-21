(ns petmimado.pages
  (:require [petmimado.text :refer [text]]
            [petmimado.urls :refer [urls]]
            [petmimado.services :as services]
            [hiccup.page :refer [html5]]
            [optimus.hiccup]
            [optimus.link :as link]
            [hiccup.form :refer [form-to submit-button]]))

(defn navbar [request color]
  (let [nav-class (if (= color :white)
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
         [:a {:href (:plans urls) :title (:plans text)} [:span {:data-hover (:plans text)} (:plans text)]]]
        [:li
         [:a {:href (:about urls) :title "Sobre nós"} [:span {:data-hover "Sobre nós"} "Sobre nós"]]]
        [:li.dropdown
         [:a.dropdown-toggle {:href "#" :data-toggle "dropdown"}
          [:span {:data-hover "Serviços"} "Serviços"] [:b.caret]]
         [:ul.dropdown-menu
          (for [{url :url title :title} [services/bath-and-gromming
                                         services/aesthetics
                                         services/exotic
                                         services/training]]
            [:li
             [:a {:href url :title title} title]])]]
        [:li
         [:a {:href (:contact urls) :title "Contato"} [:span {:data-hover "Contato"} "Contato"]]]]]]]))

(defn footer [request]
  [:div.footer
    [:div.container
     [:div.row
      [:div.col-md-3
       [:h6 "Um pouco sobre a groomer"]
       [:p [:strong "Além de ter cursado Estética Pet, fez especializações como tosa na tesoura, tosa japonesa, tosa da raça, ocorrências veterinárias no banho e tosa."]]
       [:p "Participou de Workshops com os principais Groomers do Brasil, como Flávio Fernandes e Willian Galharde."]]
      [:div.col-md-3.blog
       [:h6 "Blog"]
       [:p.title "Em construção..."]
       ;[:p "Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam."]
       ;[:p.title [:a {:href "#" :title ""} "Read this post&hellip;"]]
       ]
      [:div.col-md-3
       [:h6 "Você pode precisar disso"]
       [:ul
        [:li [:a {:href "/" :title ""} "Home"]]
        [:li [:a {:href (:about urls) :title ""} "Sobre nós"]]
        [:li [:a {:href (:contact urls) :title ""} "Contato"]]]]
      [:div.col-md-3.contact-info
       [:h6 "Mantenha contato"]
       [:p "Acompanhe Pet Mimado nas redes sociais"]
       [:p.social
        [:a.facebook {:href "https://www.facebook.com/patinhaefocinho"}]
        ;[:a.pinterest {:href "#"}]
        [:a.twitter {:href "https://twitter.com/PMimado"}]]
       [:p.c-details
        [:span "Mail"] [:a {:href (str "mailto:" (:email text))} (:email text)] [:br]
        [:span "Tel"] (:phone text)]]]
     [:div.row
      [:div.col-md-12.copyright
       [:p "© Copyright 2014. Todos direitos reservados. " [:a {:href (:contact urls) :title ""} "PetMimado"]]]]]])

(defn base [request content options]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "PetMimado | Tosa, Grooming"]
    [:link {:rel "stylesheet" :href "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/css/bootstrap.min.css"}]
    (optimus.hiccup/link-to-css-bundles request ["main.css"])
    [:link {:rel "stylesheet" :href "http://fonts.googleapis.com/css?family=Cabin:400,500,600,700,400italic,500italic,600italic,700italic"}]
    [:link {:rel "stylesheet" :href "http://fonts.googleapis.com/css?family=Lato:300,400,700,900,400italic,700italic,900italic"}]]
   [:body {:class (:class options)}
    (content request options)
    (footer request)
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/jquery.caroufredsel/6.2.1/jquery.carouFredSel.packed.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/stellar.js/0.6.2/jquery.stellar.min.js"}]
    [:script {:src "//cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.0.3a/ekko-lightbox.min.js"}]
    ;; [:script {:src "//cdnjs.cloudflare.com/ajax/libs/gmaps.js/0.4.12/gmaps.min.js"}]
    (optimus.hiccup/link-to-js-bundles request ["main.js"])]))

(defn saiba-mais
  ([url] (saiba-mais url "btn-lg"))
  ([url klass]
    (form-to [:get url]
      (submit-button {:class (str "btn btn-default " klass)} "Saiba mais"))))

(defn contact-us [request options]
  (list
   (navbar request :white)
   ;; Contact
   [:div.container
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Contato"]]
      [:p  (:contact-intro text)]]]]

   ;; Map
   [:div#map
    [:iframe {:frameborder 0 :style "border:0" :src "https://www.google.com/maps/embed/v1/view?zoom=16&center=-23.6110%2C-46.6834&key=AIzaSyDw51lp1J650cIo5QNqU6MfbuWESrYnVBg"}]]

   ;; Content
   [:div.container.content
    [:div.row
     [:div.col-md-9
      [:form#contact_form {:role "form" :action "//forms.brace.io/contato@petmimado.com" :method "POST"}
       [:div.form-group
        [:label {:for "InputName"} "Seu nome"]
        [:input#InputName.form-control {:type "text" :placeholder "Seu nome" :name "Nome"}]]
       [:div.form-group
        [:label {:for "InputEmail"} "Seu email"]
        [:input#InputEmail.form-control {:type "email" :placeholder "Seu email" :name "_replyto"}]]
       [:div.form-group
        [:label {:for "Message"} "Sua mensagem"]
        [:textarea#Message.form-control {:placeholder "Sua mensagem" :rows 8 :name "Mensagem"}]]
       [:button.btn.btn-default.btn-green {:type "submit" } "Enviar"]]]
     [:div.col-md-3
      [:ul.contact-info
       [:li.telephone (:phone text)]
       [:li.address "R. Califórnia 693 São Paulo - SP"]
       [:li.mail (:email text)]]]]]))

(defn services-single [service request options]
  (list
   (navbar request :white)
   [:div#service-p1.container
    [:div.row.services-single
     [:div.col-md-6
      [:img {:src (link/file-path request (:image service)) :alt (:title service)}]]
     [:div.col-md-6
      [:h2 (:title service)]
      (:description service)
      [:div.hours
       [:div
        [:p.day [:strong "Segunda à Sexta"]]
        [:p.time [:strong "07:00 - 20:00"]]]
       [:div
        [:p.day [:strong "Sábado e Domingo"]]
        [:p.time [:strong "8:00 - 20:00"]]]
       ]]]]

   ;; Prices
   (when (:prices service)
     [:div.prices.services {:data-stellar-background-ratio ".3"}
      [:div.container
       (map (fn [[column-size column-offset & service-row]]
         [:div.row
          (map-indexed (fn [idx {:keys [title image items]}]
           [:div.costs {:class (str "col-md-" column-size
                                    (when (zero? idx) (str " col-md-offset-" column-offset)))}
            [:div
             [:img {:src image :alt title}]
             [:h4 title]
             (map (fn [x] (apply (fn
              ([desc value] [:p (str desc " - ") [:span.per-night value]])
              ([desc] [:p desc])) x)) items)
             ;[:form {:method "get"}
             ;[:button {:type "submit" :class "btn btn-default btn-green"} "Agende agora"]]
             ]])
          service-row)]
       ) (:prices service))]])))

(defn about [request options]
  (list
   (navbar request :white)
   [:div.container
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Sobre nós"]]
      (:about-intro text)]]]
   [:div.staff {:data-stellar-background-ratio ".3"}
    [:div.container
     [:div.row
      [:div.col-md-3.col-md-offset-2.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "https://twitter.com/PMimado"}]
         [:a.facebook {:href "#"}]
         [:img {:src (link/file-path request "/images/profile2.png") :alt ""}]]
        [:h4 "Maria Claudia"]
        [:p (:about-maria text)]]]
      [:div.col-md-3.member.col-md-offset-1.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "https://twitter.com/ccanassa"}]
         [:a.facebook {:href "https://www.facebook.com/cesar.canassa"}]
         [:img {:src (link/file-path request "/images/profile3.png") :alt ""}]]
        [:h4 "Cesar Canassa"]
        [:p (:about-cesar text)]]]]]]
   [:div.container.content
    [:div.row
     [:div.col-md-6
      [:h3 [:span "Sobre o nosso Banho & Tosa"]]
      [:p "Oferecemos uma grande variedade de serviços de Pet Grooming para cuidar de seu animal de estimação. Experimente um banho relaxante de cupuaçu e maracujá ou uma hidratação de coco que irá adicionar a úmidade de volta para a pele e pelagem do seu animal de estimação. "]
      [:p "Fazer Pawdicure que vai matar o fungo das patinhas e suavizar as almofadas do seu animal (ótimo para cães com alergias), ou obter um estilo completo com um corte de pelos a seu gosto. "]
      [:p "Durante a secagem os pets recebem uma massagem relaxante, os que podem e gostam se distraem com quitutes caninos."]
      [:p "Você pode optar por uma tosa padrão (da raça) ou o serviço de styling criativo para aqueles que adoram dar um estilo único ao seu pet."]
      [:p "Considere mechas coloridas, Soft Claws (Unhas de vinil), cauterização, pintura de unhas, tatuagens para todos, ou adicionar alguma cor a cauda do seu animal de estimação, orelhas, cabeça ou todo o seu corpo! Se você quiser, podemos fazê-lo, tudo que você tem a fazer é pedir!"]
      [:p "Forma de pagamento: Não trabalho com cartão e para facilitar o pagamento temos 3 opções, dinheiro, cheque ou doc antecipado! Trabalho com Citibank e Itaú."]]
     [:div.col-md-6
      [:h3 [:span "Política do Banho e Tosa"]]
      [:p "Para manter as coisas acontecendo tranquilamente, peço que os clientes sigam estas regras:"]
      [:ol
       [:li "Todos os animais devem estar em dia com sua carteirinha de vacinação."]
       [:li "Os clientes devem chegar na hora, existindo uma tolerância de 10 minutos de atraso, caso ultrapasse este tempo seu horário será doado a outro cliente."]
       [:li "Todos os clientes devem fornecer, nome, telefone e e-mail para contato."]
       [:li "Os clientes devem buscar os pets no horário designado, existindo uma tolerância de 10 minutos, ultrapassando este tempo será cobrada taxa extra."]
       [:li "Cancelamentos devem ser feitos com 24 hrs de antecedência."]
       [:li "Qualquer animal de estimação que se encontre com pulgas ou carrapatos será tratado com capstar e será cobrado á parte."]
       [:li "Por favor informe a grommer de qualquer problema de saúde que seu animal de estimação tenha, para que ela possa mantê-lo o mais confortável possível."]
       [:li "Não é permitido que o proprietário fique com o animal de estimação durante o banho e tosa. Isto é para a segurança de todos."]]
      [:p "Se você tiver alguma dúvida ou preocupação, não hesite em perguntar! Essas políticas são feitas para manter todos seguros e felizes, e para assegurar que os nossos clientes não sejam incomodados."]]]]))

(defn home [request options]
  (list
  (navbar request :green)
  ;; Slider
  [:div#home_carousel {:class "carousel slide" :data-ride "carousel"}
   [:ol.carousel-indicators
    [:li.active {:data-target "#home_carousel" :data-slide-to "0"}]
    [:li {:data-target "#home_carousel" :data-slide-to "1"}]]

   ;; Wrapper for slides
   [:div.carousel-inner
    [:div.item.active
     [:img {:src (link/file-path request "/images/masthead/bg-1.jpg") :alt ""}]
     [:div.carousel-caption
      [:h2 (:home-title-1 text)]
      [:p (:home-subtitle-1 text)]
      (saiba-mais (:about urls))]]
    [:div.item
     [:img {:src (link/file-path request "/images/masthead/bg-2.jpg") :alt ""}]
     [:div.carousel-caption
      [:h2 (:home-title-2 text)]
      [:p (:home-subtitle-2 text)]
      (saiba-mais (:training urls))]]]

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
                            (saiba-mais url "btn-green")]) [services/bath-and-gromming
                                                            services/aesthetics
                                                            services/exotic])))
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span (:our-customers text)]]
      ;[:p (:our-customers-description text)]
      ]]]

   ;; Carousel
   [:div#c-carousel
    [:div#Wrapper
     [:div#carousel
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/mell.jpg") :title "Mell" :data-hover "Mell, a Shih Tzu" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/mell.jpg") :alt "Mell"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/dominique.jpg") :title "Domique" :data-hover "Domique, a Maltês" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/dominique.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/damasco.jpg") :title "Damasco" :data-hover "Damasco, o Mastiff" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/damasco.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/fred.jpg") :title "Fred" :data-hover "Fred, o Angorá" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/fred.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/bob.jpg") :title "Bob" :data-hover "Bob, o Yorkshire" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/bob.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/mell.jpg") :title "Mell" :data-hover "Mell, a Shih Tzu" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/mell.jpg") :alt "Mell"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/dominique.jpg") :title "Domique" :data-hover "Domique, a Maltês" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/dominique.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/damasco.jpg") :title "Damasco" :data-hover "Damasco, o Mastife" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/damasco.jpg") :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href (link/file-path request "/images/clientes/fred.jpg") :title "Fred" :data-hover "Fred, o Angorá" :data-toggle "lightbox"}
        [:img {:src (link/file-path request "/images/clientes/fred.jpg") :alt "Dog"}]]]]
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
