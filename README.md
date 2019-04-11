# QA_SortableList_Challenge

Olá, para conseguir executar os testes, será necessário você seguir esse tutorial.

1) baixar o docker e instalar o mesmo em sua máquina. O link para download é: `https://hub.docker.com/editions/community/docker-ce-desktop-windows`
    1.1) Após a instalação do docker, você precisa efetuar login nele. Logo depois, clique com o botão direito e acesse a opção settings. Vá até o menu "shared drivers" e habilite a unidade onde você vai clonar os repositórios. Nesse momento, é possível que você efetue login com credenciais do windows, para que a pasta possa ser compartilhada com o docker.

2) Clone o repositório dos meus testes que estão disponíveis em:: 
`https://github.com/daniellnog/QA_SortableList_Challenge.git`

3) Depois que você já tiver instalado o docker, você vai precisar clonar a aplicação a ser testada. 
`https://bitbucket.org/mindera/qa-sortable-challenge.git`

4) Uma vez que você já tenha clonado os dois repositórios, você precisará baixar o node.js, disponível em: 
`https://nodejs.org/en/`

5) Após a instalação do node, entre na pasta raiz da aplicação clonada no item 3 e posteriormente execute os seguintes comandos: 
    5.1) `npm install -g parcel`
    5.2) `npm install`
    5.3) `npm start`
    
    Feito isso, a aplicação a ser testada estará funcionando na sua máquina local, na porta 3000. Para verificar se a aplicação está realmente disponível, abra o seu browser e digite localhost:3000.
 
 6) Considerando que você já está com a aplicação a ser testada rodando localmente, abra o prompt de comando e navegue até a pasta raiz do repositório que você clonou no item 2.
 Feito isso, você precisa digitar os seguintes comandos: 
    6.1) `docker pull elgalu/selenium`
    6.2) `docker pull dosel/zalenium`
    6.3) Execute o comando: `mkdir videos`
    6.4) Execute o seguinte comando: `docker run --rm -ti --name zalenium -p 4444:4444 ^ -v /var/run/docker.sock:/var/run/docker.sock ^ -v seuDiretorio/videos:/home/seluser/videos ^ --privileged dosel/zalenium start`.
        obs.: Substitua **seuDiretorio** pela pasta raiz da aplicação clonada no item 2.
    6.4) Agora o container para você verificar a execução do teste já está disponível na o endereço localhost:4444. 
    6.5) Acesse `http://localhost:4444/grid/admin/live` para puder ver as execuções sendo realizadas em tempo real.
 
 7) Agora você precisa configurar algumas coisas referente ao teste. Edite o arquivo `sortable_testng.xml` com algum editor de texto, como o notepad++. Nele, você encontrará um nó "test", isso é responsável por um teste. 
    7.1) Nesse momento, você precisa preencher qual o IP de sua máquina. Para isso, vá ao prompt de comando e digite: ipconfig. 
    7.2) Após fazer isso, você precisa alterar a propriedade "value" do nó "parameter" e colocar o seu IP.
    7.3) Se você quiser executar o teste mais de uma vez, copie o codigo "test" e cole quantas vezes você quiser que o mesmo seja executado. **Atente para alterar a propriedade name, pois não é possível ter mais de um teste com o mesmo nome.** 
 
 8) Após isso, você vai buildar o container. Você precisa estar na raiz do diretorio clonado no item 2. Utilize o seguinte código: "`docker build -t=daniel-nogueira/selenium-docker .`". Após esse comando ser finalizado com sucesso, todos os recursos necessários para a execução de nossos testes estarão prontos.
 
 10) Inicie o container com o seguinte comando: "`docker run -e MODULE=sortable_testng.xml -v seuDiretorio\output\:/usr/share/daniel/test-output daniel-nogueira/selenium-docker`".
    10.1) Você deve substituir **seuDiretorio** pelo diretório da pasta raiz que está o projeto clonado no item 2.
 Nessa linha estamos passando por parâmetro o nosso arquivo xml como input para nosso teste ser executado. Neste momento, o teste já será executado no container e você pode verificar a execução em tempo real no endereço: `http://localhost:4444/grid/admin/live` 
 
 Pronto, para verificar a saída dos testes, você pode, na sua máquina local, ir até a sua pasta e verificar a pasta output, onde estará todas as informações referentes aos testes que foram executados. Acessando o arquivo index.html você tem um painel com maiores informações sobre os testes.
 Além disso, é possível verificar um dashboard, com todas as informações dos testes, incluindo vídeos que são gerados como evidências. Acesse `http://localhost:4444/dashboard` 
                                                                        