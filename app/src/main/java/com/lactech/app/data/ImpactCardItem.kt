package com.lactech.app.data

data class ImpactCardItem(
    val title: String,
    val description: String,
    val statHighlight: String? = null
)

object ImpactDataProvider {
    val impactItems = listOf(
        ImpactCardItem(
            title = "Pequenos gestos, grandes vidas",
            description = "Um único pote de leite pode alimentar até 10 bebês recém-nascidos internados por dia.",
            statHighlight = "Até 10 bebês/dia"
        ),
        ImpactCardItem(
            title = "Impacto que cresce a cada ano",
            description = "Mais de 18 mil litros de leite já foram coletados pelo programa Lactare desde 2019.",
            statHighlight = "+18.000 Litros"
        ),
        ImpactCardItem(
            title = "Pioneirismo que transforma",
            description = "O Lactare se destaca como o primeiro banco de leite privado do Brasil.",
            statHighlight = "1º Banco Privado"
        ),
        ImpactCardItem(
            title = "Uma rede de mães solidárias",
            description = "Desde o início do programa, mais de 16 mil mulheres já se cadastraram como doadoras.",
            statHighlight = "+16.000 Doadoras"
        ),
        ImpactCardItem(
            title = "Uma rede presente em todo o país",
            description = "O Brasil conta com 238 bancos de leite e 257 postos de coleta distribuídos por todos os estados e o DF.",
            statHighlight = "238 Bancos / 257 Postos"
        ),
        ImpactCardItem(
            title = "Parcerias que salvam vidas",
            description = "A Lactare possui parcerias com diversos hospitais, como Hospital das Clínicas, Hospitais Gerais e rede pública.",
            statHighlight = "Hospitais & UTIs"
        )
    )
}

