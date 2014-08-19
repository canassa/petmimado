(ns petmimado.services
	(:require [petmimado.urls :refer [urls]]
            [petmimado.text :refer [text]]))

(def plans
	{:url (:bath urls)
   :title (:plans text)
   :description (:plans-description text)
   :image "/images/planos.jpg"
   :icon-class "kennel-img"
   :prices [[4 0 {:title (:bronze-plan text)
             :image "/images/medal-3rd.png"
             :items [["4 Banhos"]
                     ["1 Tosa higiênica"]
                     ["1 Hidratação"]
                     ["&nbsp;"]]}
            {:title (:silver-plan text)
             :image "/images/medal-2nd.png"
             :items [["4 Banhos"]
                     ["1 Tosa higiênica"]
                     ["1 Tosa geral"]
                     ["1 Hidratação"]]}
            {:title (:gold-plan text)
             :image "/images/medal-1st.png"
             :items [["4 Banhos"]
                     ["2 Tosas higiênicas"]
                     ["1 Tosa da raça"]
                     ["1 Hidratação"]]}]]})

(def bath-and-gromming
  {:url (:bath-and-gromming urls)
   :title (:bath-and-gromming text)
   :short-description (:bath-and-gromming-short-description text)
   :description (:bath-and-gromming-description text)
   :icon-class "kennel-img"
   :image "/images/banho-e-tosa.jpg"
   :prices [[3 0 {:title (:tiny-dog text)
             :image "/images/small-dog.png"
             :items [["Banho" "R$ 25,00"]
                     ["Tosa máquina" "R$ 42,00"]
                     ["Tosa tesoura" "R$ 52,00"]
                     ["Tosa da raça" "R$ 52,00"]
                     ["Tosa higiênica" "R$ 12,00"]]}
            {:title (:small-dog text)
             :image "/images/medium-dog.png"
             :items [["Banho" "R$ 30,00"]
                     ["Tosa máquina" "R$ 44,00"]
                     ["Tosa tesoura" "R$ 54,00"]
                     ["Tosa da raça" "R$ 54,00"]
                     ["Tosa higiênica" "R$ 12,00"]]}
            {:title (:medium-dog text)
             :image "/images/large-dog.png"
             :items [["Banho" "R$ 35,00"]
                     ["Tosa máquina" "R$ 49,00"]
                     ["Tosa tesoura" "R$ 59,00"]
                     ["Tosa da raça" "R$ 59,00"]
                     ["Tosa higiênica" "R$ 12,00"]]}
            {:title (:large-dog text)
             :image "/images/xlarge-dog.png"
             :items [["Banho" "R$ 40,00"]
                     ["Tosa máquina" "R$ 51,00"]
                     ["Tosa tesoura" "R$ 61,00"]
                     ["Tosa da raça" "R$ 61,00"]
                     ["Tosa higiênica" "R$ 12,00"]]}]
            [4 4 {:title (:cats text)
             :image "/images/cat.png"
             :items [["Banho" "R$ 35,00"]
                     ["Tosa geral" "R$ 50,00"]
                     ["Tosa higiênica" "R$ 15,00"]
                     ["Capa unhas (dianteiras)" "R$ 70,00"]
                     ["Capa unhas (4 patas)" "R$ 140,00"]
                     ["Reposição capa unha" "R$ 7,00"]]}]]})

(def aesthetics
  {:url (:aesthetics urls)
   :title (:aesthetics text)
   :short-description (:aesthetics-short-description text)
   :description (:aesthetics-description text)
   :icon-class "kennel-img"
   :image "/images/estetica.jpg"
   :prices [[3 0 {:title (:tiny-dog text)
           :image "/images/small-dog.png"
           :items [["Mechas" "R$ 3,00 por mecha"]
                   ["Tingimento" "R$ 20,00"]
                   ["Cauterização" "R$ 20,00"]
                   ["Petcure" "R$ 5,00"]
                   ["Penteados" "R$ 20,00 a R$ 30,00"]
                   ["Escovas" "R$ 25,00"]
                   ["Hidratações" "R$ 25,00"]
                   ["Medicamentosos" "R$ 15,00"]
                   ["Higiene Bucal" "R$ 7,00"]
                   ["Tatuagens" "R$ 5,00"]]}
           {:title (:small-dog text)
           :image "/images/medium-dog.png"
           :items [["Mechas" "R$ 3,00 por mecha"]
                   ["Tingimento" "R$ 30,00"]
                   ["Cauterização" "R$ 30,00"]
                   ["Petcure" "R$ 5,00"]
                   ["Penteados" "R$ 20,00 a R$ 30,00"]
                   ["Escovas" "R$ 35,00"]
                   ["Hidratações" "R$ 35,00"]
                   ["Medicamentosos" "R$ 17,00"]
                   ["Higiene Bucal" "R$ 9,00"]
                   ["Tatuagens" "R$ 7,00"]]}
           {:title (:medium-dog text)
           :image "/images/large-dog.png"
           :items [["Mechas" "R$ 3,00 por mecha"]
                   ["Tingimento" "R$ 40,00"]
                   ["Cauterização" "R$ 40,00"]
                   ["Petcure" "R$ 5,00"]
                   ["Penteados" "R$ 20,00 a R$ 30,00"]
                   ["Escovas" "R$ 45,00"]
                   ["Hidratações" "R$ 45,00"]
                   ["Medicamentosos" "R$ 19,00"]
                   ["Higiene Bucal" "R$ 11,00"]
                   ["Tatuagens" "R$ 9,00"]]}
           {:title (:large-dog text)
           :image "/images/xlarge-dog.png"
           :items [["Mechas" "R$ 3,00 por mecha"]
                   ["Tingimento" "R$ 50,00"]
                   ["Cauterização" "R$ 50,00"]
                   ["Petcure" "R$ 5,00"]
                   ["Penteados" "R$ 20,00 a R$ 30,00"]
                   ["Escovas" "R$ 55,00"]
                   ["Hidratações" "R$ 55,00"]
                   ["Medicamentosos" "R$ 21,00"]
                   ["Higiene Bucal" "R$ 13,00"]
                   ["Tatuagens" "R$ 11,00"]]}]]})

(def exotic
  {:url (:exotic urls)
   :title (:exotic text)
   :short-description (:exotic-short-description text)
   :description (:exotic-description text)
   :image "/images/coelho.jpg"
   :icon-class "kennel-img"
   :prices [[4 0 {:title (:rabbits text)
                   :image "/images/coelho.png"
                   :items [["Banho" "R$ 44,00"]
                           ["Tosa geral" "R$ 50,00"]
                           ["Tosa higiênica" "R$ 15,00"]]}
                 {:title (:ferrets text)
                   :image "/images/ferret.png"
                   :items [["Banho" "R$ 30,00"]
                           ["&nbsp"] ["&nbsp"]]}
                 {:title (:guinea-pigs text)
                   :image "/images/guinea-pig.png"
                   :items [["Banho" "R$ 40,00"]
                           ["Tosa" "R$ 50,00"]
                           ["&nbsp"]]}]]})

(def training
  {:url (:training urls)
   :title (:training text)
   :short-description (:training-short-description text)
   :description (:training-description text)
   :image "/images/treinamento.jpg"
   :icon-class "kennel-img"})
