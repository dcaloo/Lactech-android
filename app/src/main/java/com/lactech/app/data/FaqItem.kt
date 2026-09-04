package com.lactech.app.data

data class FaqItem(
    val id: Int,
    val question: String,
    val answer: String
)

object FaqDataProvider {
    val faqList = listOf(
        FaqItem(
            id = 1,
            question = "A coleta é gratuita?",
            answer = "Sim. A coleta do leite materno é totalmente gratuita e realizada pelo programa Lactare, da Eurofarma. Após o agendamento com o Banco de Leite Humano, a coleta pode ser feita diretamente na sua casa."
        ),
        FaqItem(
            id = 2,
            question = "Onde posso doar?",
            answer = "Para doar, basta localizar o Banco de Leite Humano mais próximo da sua residência informando o seu CEP. A coleta é realizada pelo programa Lactare, da Eurofarma. Entre em contato com o banco de leite e agende a visita para a coleta diretamente em sua casa."
        ),
        FaqItem(
            id = 3,
            question = "Quem pode doar?",
            answer = "Para doar, é necessário estar saudável, amamentando e produzir leite em quantidade suficiente para o bebê. Também é importante seguir as orientações do Banco de Leite Humano durante o processo de doação."
        ),
        FaqItem(
            id = 4,
            question = "Como posso receber?",
            answer = "Para receber leite materno doado, procure um Banco de Leite Humano ou unidade de saúde da sua região. A equipe avaliará a necessidade e orientará sobre o processo de recebimento, conforme a disponibilidade."
        ),
        FaqItem(
            id = 5,
            question = "Há testes feitos no leite?",
            answer = "Sim. O leite humano doado passa por rigorosas análises físico-químicas e microbiológicas antes de ser pasteurizado e oferecido aos bebês, garantindo total qualidade e segurança."
        ),
        FaqItem(
            id = 6,
            question = "Há algum ponto de coleta perto de mim?",
            answer = "Sim! O Brasil conta com 238 bancos de leite e 257 postos de coleta distribuídos por todos os estados. Você pode consultar a rede Lactare ou o banco de leite do seu município para saber o ponto mais próximo."
        ),
        FaqItem(
            id = 7,
            question = "Como é feito o armazenamento do leite?",
            answer = "O leite deve ser armazenado em recipiente de vidro com tampa plástica, devidamente limpo e esterilizado (fervido por 15 minutos). Após a coleta, ele deve ser mantido congelado até o recolhimento."
        ),
        FaqItem(
            id = 8,
            question = "Há suporte emocional para as famílias?",
            answer = "Sim. As famílias contam com acolhimento, orientação e suporte técnico das equipes multidisciplinares dos Bancos de Leite Humano durante todo o processo de amamentação e doação."
        ),
        FaqItem(
            id = 9,
            question = "Quem precisa receber o leite humano?",
            answer = "O leite humano doado é destinado prioritariamente a bebês prematuros, de baixo peso ou internados em UTIs neonatais que não podem ser alimentados diretamente pela própria mãe."
        ),
        FaqItem(
            id = 10,
            question = "Preciso produzir muito leite para doar?",
            answer = "Não! Qualquer quantidade excedente é valiosa. Apenas 1 pote de leite materno pode alimentar até 10 recém-nascidos internados por dia."
        )
    )
}

