# github-repo-viewer

Aplicativo para consultar API do Github e trazer os repositórios mais populares de Java ou Kotlin

Lista de repositórios. 
Exemplo de chamada na API: https://api.github.com/search/repositories?q=language:Java&sort=stars&page=1

- [ ] Suportar mudanças de orientação das telas sem perder estado
- [ ] Paginação na tela de lista, com endless scroll
- [ ] Cada repositório deve exibir: Nome do repositório, Descrição do Repositório, Nome/Foto do autor, Número de Stars, Número de Forks
- [ ] Cache de imagens
- [ ] Coroutines para comunicação com a API
- [ ] Cache da API
- [ ] Testes no projeto (unitários e por tela)
- [ ] Testes instrumentados/funcionais (que naveguem pelo aplicativo como casos de uso)
