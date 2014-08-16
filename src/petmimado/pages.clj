(ns petmimado.pages
  (:require [petmimado.text :refer [text]]
            [petmimado.urls :refer [urls]]
            [hiccup.page :refer [html5]]
            [hiccup.form :refer [form-to submit-button]]))



(def services
  [{:key :bath-and-gromming
    :url (:bath-and-gromming urls)
    :title (:bath-and-gromming text)
    :short-description (:bath-and-gromming-short-description text)
    :description (:bath-and-gromming-description text)
    :icon-class "kennel-img"
    :image "/images/banho-e-tosa.jpg"
    :prices [{:title (:tiny-dog text)
              :image "/images/small-dog.png"
              :items [["Banho" "R$ 25,00"]
                      ["Tosa máquina" "R$ 42,00"]
                      ["Tosa tesoura" "R$ 52,00"]
                      ["Tosa da raça" "R$ 52,00"]
                      ["Tosa higiênica" "R$ 12,00"]]}
             {:title (:small-dog text)
              :image "/images/medium-dog.png"
              :items [["Banho" "R$ 27,00"]
                      ["Tosa máquina" "R$ 44,00"]
                      ["Tosa tesoura" "R$ 54,00"]
                      ["Tosa da raça" "R$ 54,00"]
                      ["Tosa higiênica" "R$ 12,00"]]}
             {:title (:medium-dog text)
              :image "/images/large-dog.png"
              :items [["Banho" "R$ 29,00"]
                      ["Tosa máquina" "R$ 49,00"]
                      ["Tosa tesoura" "R$ 59,00"]
                      ["Tosa da raça" "R$ 59,00"]
                      ["Tosa higiênica" "R$ 12,00"]]}
             {:title (:large-dog text)
              :image "/images/xlarge-dog.png"
              :items [["Banho" "R$ 31,00"]
                      ["Tosa máquina" "R$ 51,00"]
                      ["Tosa tesoura" "R$ 61,00"]
                      ["Tosa da raça" "R$ 61,00"]
                      ["Tosa higiênica" "R$ 12,00"]]}]}

   {:key :aesthetics
    :url (:aesthetics urls)
    :title (:aesthetics text)
    :short-description (:aesthetics-short-description text)
    :description (:aesthetics-description text)
    :icon-class "kennel-img"
    :image "/images/estetica.jpg"
    :prices [{:title (:tiny-dog text)
            :image "/images/small-dog.png"
            :items [["Mechas" "R$ 3,00 por mecha"]
                    ["Tingimento" "R$ 15,00"]
                    ["Calterização" "R$ 20,00"]
                    ["Petcure" "R$ 5,00"]
                    ["Penteados" "R$ 20,00 a R$ 30,00"]
                    ["Escovas" "R$ 15,00"]
                    ["Hidratações" "R$ 20,00"]
                    ["Medicamentosos" "R$ 15,00"]
                    ["Higiene Bucal" "R$ 7,00"]
                    ["Tatuagens" "R$ 5,00"]]}
           {:title (:small-dog text)
            :image "/images/medium-dog.png"
            :items [["Mechas" "R$ 3,00 por mecha"]
                    ["Tingimento" "R$ 17,00"]
                    ["Calterização" "R$ 23,00"]
                    ["Petcure" "R$ 5,00"]
                    ["Penteados" "R$ 20,00 a R$ 30,00"]
                    ["Escovas" "R$ 17,00"]
                    ["Hidratações" "R$ 22,00"]
                    ["Medicamentosos" "R$ 17,00"]
                    ["Higiene Bucal" "R$ 9,00"]
                    ["Tatuagens" "R$ 7,00"]]}
           {:title (:medium-dog text)
            :image "/images/large-dog.png"
            :items [["Mechas" "R$ 3,00 por mecha"]
                    ["Tingimento" "R$ 19,00"]
                    ["Calterização" "R$ 26,00"]
                    ["Petcure" "R$ 5,00"]
                    ["Penteados" "R$ 20,00 a R$ 30,00"]
                    ["Escovas" "R$ 19,00"]
                    ["Hidratações" "R$ 24,00"]
                    ["Medicamentosos" "R$ 19,00"]
                    ["Higiene Bucal" "R$ 11,00"]
                    ["Tatuagens" "R$ 9,00"]]}
           {:title (:large-dog text)
            :image "/images/xlarge-dog.png"
            :items [["Mechas" "R$ 3,00 por mecha"]
                    ["Tingimento" "R$ 21,00"]
                    ["Calterização" "R$ 30,00"]
                    ["Petcure" "R$ 5,00"]
                    ["Penteados" "R$ 20,00 a R$ 30,00"]
                    ["Escovas" "R$ 21,00"]
                    ["Hidratações" "R$ 26,00"]
                    ["Medicamentosos" "R$ 21,00"]
                    ["Higiene Bucal" "R$ 13,00"]
                    ["Tatuagens" "R$ 11,00"]]}]}

   {:key :exotic
    :url (:exotic urls)
    :title (:exotic text)
    :short-description (:exotic-short-description text)
    :description (:exotic-description text)
    :image "/images/coelho.jpg"
    :icon-class "kennel-img"}

   {:key :training
    :url (:training urls)
    :title (:training text)
    :short-description (:training-short-description text)
    :description (:training-description text)
    :image "/images/treinamento.jpg"
    :icon-class "kennel-img"}
   ])

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
         [:a {:href (:plans urls) :title (:plans text)} [:span {:data-hover (:plans text)} (:plans text)]]]
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
        [:a.twitter {:href "#"}]]
       [:p.c-details
        [:span "Mail"] [:a {:href (str "mailto:" (:email text))} (:email text)] [:br]
        [:span "Tel"] (:phone text)]]]
     [:div.row
      [:div.col-md-12.copyright
       [:p "© Copyright 2014. Todos direitos reservados. " [:a {:href (:contact urls) :title ""} "PetMimado"]]]]]])

(defn base [content page]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:title "PetMimado | Tosa, Grooming"]
    [:link {:rel "stylesheet" :href "//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/css/bootstrap.min.css"}]
    [:link {:rel "stylesheet" :href "/css/style.css"}]
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
    [:script {:src "/js/custom.js"}]]))

(defn saiba-mais
  ([url] (saiba-mais url "btn-lg"))
  ([url klass]
    (form-to [:get url]
      (submit-button {:class (str "btn btn-default " klass)} "Saiba mais"))))

(def contact-us
  (list
   (navbar :white)
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
       [:li.telephone (:phone text)]
       [:li.address "R. Califórnia 693 São Paulo - SP"]
       [:li.mail (:email text)]]]]]))

(defn services-single [service]
  (list
   (navbar :white)
   [:div#service-p1.container
    [:div.row.services-single
     [:div.col-md-6
      [:img {:src (:image service) :alt (:title service)}]]
     [:div.col-md-6
      [:h2 (:title service)]
      (map (fn [p] [:p p]) (:description service))
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
       [:div.row
        (map (fn [{:keys [title image items]}]
               [:div.col-md-3.costs
                [:div
                 [:img {:src image :alt title}]
                 [:h4 title]
                 (map (fn [x]
                        (apply
                          (fn
                            ([desc value] [:p (str desc " - ") [:span.per-night value]])
                            ([desc] [:p desc])) x)) items)
                 [:form {:method "get"}
                  [:button {:type "submit" :class "btn btn-default btn-green"} "Agende agora"]]]])
             (:prices service))
        ]]])))

(def about
  (list
   (navbar :white)
   [:div.container
    [:div.row
     [:div.col-md-12.centered
      [:h3 [:span "Sobre nós"]]
      [:p (:about-intro text)]]]]
   [:div.staff {:data-stellar-background-ratio ".3"}
    [:div.container
     [:div.row
      [:div.col-md-3.col-md-offset-2.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "#"}]
         [:a.facebook {:href "#"}]
         [:img {:src "/images/profile2.png" :alt ""}]]
        [:h4 "Maria Claudia"]
        [:p (:about-maria text)]]]
      [:div.col-md-3.member.col-md-offset-1.member
       [:div {:data-stellar-ratio "1.2" :data-stellar-vertical-offset "150" :data-stellar-horizontal-offset "0"}
        [:span
         [:a.twitter {:href "#"}]
         [:a.facebook {:href "#"}]
         [:img {:src "/images/profile3.png" :alt ""}]]
        [:h4 "Cesar Canassa"]
        [:p (:about-cesar text)]]]]]]
   [:div.container.content
    [:div.row
     [:div.col-md-6
      [:h3 [:span "Sobre o nosso Banho & Tosa"]]
      [:p "Nós oferecemos uma grande variedade de serviços de Pet Grooming para cuidar de seu animal de estimação. Experimente um banho relaxante de cupuaçu e maracujá ou uma hidratação de coco que irá adicionar a úmidade de volta para a pele e pelagem do seu animal de estimação. "]
      [:p "Fazer Pawdicure que vai matar o fungo das patinhas e suavizar as almofadas do seu animal (ótimo para cães com alergias), ou obter um estilo completo com um corte de pelos a seu gosto. "]
      [:p "Durante a secagem os pets recebem uma massagem relaxante, os que podem e gostam se distraem com quitutes caninos."]
      [:p "Você pode optar por uma tosa padrão ( da raça) ou o serviço de styling criativo para aqueles que adoram dar um estilo único ao seu pet."]
      [:p "Considere mechas coloridas, Soft Claws (Unhas de vinil), cauterização, pintura de unhas, tatuagens para todos, ou adicionar alguma cor a cauda do seu animal de estimação, orelhas, cabeça ou todo o seu corpo! Se você quiser, podemos fazê-lo, tudo que você tem a fazer é pedir!"]]
     [:div.col-md-6
      [:h3 [:span "Política do Banho e Tosa"]]
      [:p "Pet Mimado é uma entidade privada e para manter as coisas acontecendo tranquilamente, pedimos que nossos clientes sigam estas regras:"]
      [:ol
       [:li "Todos os animais devem estar em dia com sua carteirinha de vacinação e esta deve ser entregue a groomer no momento do banho e tosa."]
       [:li "Os clientes devem chegar na hora, existindo uma tolerância de 10 minutos de atraso, caso ultrapasse este tempo seu horário será doado a outro cliente."]
       [:li "Todos os clientes devem fornecer, nome, telefone e e-mail para contato."]
       [:li "Os clientes devem buscar os pets no horário designado, existindo uma tolerância de 10 minutos, ultrapassando este tempo será cobrada taxa extra."]
       [:li "Cancelamentos devem ser feitos com 24 hrs de antecedência."]
       [:li "Qualquer animal de estimação que se encontre com pulgas e carrapatos, será tratado com capstar, banho antipulgas e cobrado á parte."]
       [:li "Por favor, informe-nos de qualquer problema de saúde que seu animal de estimação tenha, para que possamos mantê-lo o mais confortável possível."]
       [:li "Não é permitido que o proprietário fique com o animal de estimação durante o banho e tosa. Isto é para a segurança de todos."]]
      [:p "Se você tiver alguma dúvida ou preocupação , não hesite em perguntar! Essas políticas são feitas para manter todos seguros e felizes, e para assegurar que os nossos clientes não sejam incomodados."]]]]))


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
     [:img {:src "/images/2.png" :alt ""}]
     [:div.carousel-caption
      [:h2 (:home-title-1 text)]
      [:p (:home-subtitle-1 text)]
      (saiba-mais "/")]]
    [:div.item
     [:img {:src "/images/3.png" :alt ""}]
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
                            (saiba-mais "/" "btn-green")]) services)))
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
       [:a.lightbox {:href "/images/dog-1.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-1.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "/images/dog-2.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-2.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "/images/dog-3.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-3.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "/images/dog-1.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-1.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "/images/dog-2.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-2.png" :alt "Dog"}]]]
      [:div
       [:a.lightbox {:href "/images/dog-3.png" :title "Dog" :data-hover "Sandy the west highland terrier" :data-toggle "lightbox"}
        [:img {:src "/images/dog-3.png" :alt "Dog"}]]]]
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

(def plans
  (base
   (services-single {:key :plans
                     :url (:bath urls)
                     :title (:plans text)
                     :description (:plans-description text)
                     :image "/images/banho-e-tosa.jpg"
                     :icon-class "kennel-img"
                     :prices [{:title (:bronze-plan text)
                               :image "/images/small-dog.png"
                               :items [["4 Banhos"]
                                       ["1 Tosa higiênica"]]}
                              {:title (:silver-plan text)
                               :image "/images/medium-dog.png"
                               :items [["4 Banhos"]
                                       ["1 Tosa higiênica"]
                                       ["1 Tosa geral"]]}
                              {:title (:gold-plan text)
                               :image "/images/large-dog.png"
                               :items [["4 Banhos"]
                                       ["1 Tosa higiênica"]
                                       ["1 Tosa geral"]]}]}) "contentpage"))
