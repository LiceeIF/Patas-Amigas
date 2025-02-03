document.addEventListener("DOMContentLoaded", function () {

    const especieSelect = document.getElementById("especie");
    const racaSelect = document.getElementById("raca");

    const especiesData = {
        "Cachorro": [
            "Akita", "Basset Hound", "Beagle", "Border Collie", "Boxer", "Bull Terrier",
            "Bulldog Francês", "Bulldog Inglês", "Cane Corso", "Chihuahua", "Chow Chow",
            "Cocker Spaniel", "Collie", "Dachshund", "Dogo Argentino", "Doberman", "Fila Brasileiro",
            "Golden Retriever", "Husky Siberiano", "Labrador Retriever", "Lhasa Apso",
            "Maltês", "Pastor Alemão", "Pastor Belga", "Pit Bull", "Pinscher", "Pomerânia",
            "Poodle", "Pug", "Rottweiler", "Samoyeda", "São Bernardo", "Schnauzer",
            "Shar Pei", "Shih Tzu", "Terrier Brasileiro", "Weimaraner", "Whippet", "Yorkshire Terrier","Vira-Lata"
        ],
        "Gato": [
            "Abyssinian", "American Shorthair", "Angorá Turco", "Bengal", "Bombay",
            "British Shorthair", "Burmese", "Chartreux", "Cornish Rex", "Devon Rex",
            "Exótico", "Havana Brown", "Himalaio", "Maine Coon", "Manx", "Munchkin",
            "Norueguês da Floresta", "Persa", "Ragdoll", "Savannah", "Scottish Fold",
            "Selkirk Rex", "Siamês", "Siberiano", "Singapura", "Somali", "Sphynx",
            "Tonquinês", "Bobtail Japonês","Vira-Lata"
        ],
        "Pássaro": [
            "Agapornis", "Arara Azul", "Cacatua", "Calopsita", "Canário", "Curió",
            "Galo-da-Serra", "Jandaia", "Mandarim", "Maracanã", "Papagaio",
            "Periquito", "Pintassilgo", "Rouxinol", "Sabiá", "Tucano"
        ],
        "Réptil": [
            "Cágado", "Cobra do Milho", "Dragão Barbudo", "Gecko Leopard",
            "Iguana", "Jiboia", "Lagarto Monitor", "Tartaruga Tigre-d'Água", "Teiú"
        ],
        "Roedor": [
            "Chinchila", "Esquilo-da-Mongólia", "Hamster Anão Russo",
            "Hamster Sírio", "Porquinho-da-Índia", "Rato Dumbo"
        ],
        "Peixe": [
            "Acará Bandeira", "Acará Disco", "Betta", "Cascudo", "Guppy",
            "Kinguios", "Molinésia", "Neon Tetra", "Oscar", "Peixe Palhaço"
        ],
        "Anfíbio": [
            "Axolote", "Perereca Verde", "Rã Dourada", "Salamandra", "Sapo Cururu"
        ]
    };

    Object.keys(especiesData).forEach(especie => {
        let option = new Option(especie, especie);
        especieSelect.add(option);
    });

    especieSelect.addEventListener("change", function () {
        let especieSelecionada = this.value;
        racaSelect.innerHTML = '<option value="" disabled selected>Selecione uma raça</option>';

        if (especiesData[especieSelecionada]) {
            especiesData[especieSelecionada].forEach(raca => {
                let option = new Option(raca, raca);
                racaSelect.add(option);
            });
        }
    });
});
