# Portal Adventure

## Sobre
<p>🇧🇷 Com o Portal Adventure Mergulhe no multiverso de Rick and Morty com nosso aplicativo temático. Com uma vasta coleção de 826 personagens, você pode explorar uma seleção aleatória e detalhada de cada um deles. Descubra curiosidades fascinantes e informações exclusivas sobre todos os personagens diretamente na tela de detalhes. Não perca a chance de aprofundar seu conhecimento e se surpreender com os segredos do universo Rick and Morty!</p>

## O que utilizei no projeto

- Kotlin https://kotlinlang.org/docs/getting-started.html
- Jetpack Compose https://developer.android.com/compose
- Compose Navigation https://developer.android.com/develop/ui/compose/navigation
- Injeção de dependência (Dagger Hilt) https://developer.android.com/training/dependency-injection/hilt-android
- CI/CD com Bitrise https://devcenter.bitrise.io/
- Arquitetura MVVM + Clean
- Couroutines https://kotlinlang.org/docs/coroutines-overview.html
- Retrofit https://square.github.io/retrofit/

## API utilizada no projeto

<img width="500" alt="Captura de Tela 2024-08-05 às 17 14 06" src="https://github.com/user-attachments/assets/f43c5769-72cb-455f-8bff-539a98be99f5">

No projeto utilizamos API do Rick and Morty, pública e gratuita com fácil integração. Link da documentação: https://rickandmortyapi.com/ 

Nessa API podemos fazer consultas de personagens através de IDS e nomes, consultar episódios e listas gerais. 

## Features do projeto

- Pesquisa aleatória de personagem: Finalizado ✅
- Pesquisa por ID do persongaem: WIP ⏳
- Lista de favoritos: WIP ⏳

### Caso de sucesso
[success_example.webm](https://github.com/user-attachments/assets/5246059c-640a-4afd-8430-b8f2c7d7181d)

### Caso de erro
[error_example.webm](https://github.com/user-attachments/assets/dc4167de-d394-4c53-8f91-d19aa4310d41)

### Bottom App Bar
https://github.com/user-attachments/assets/1d6afbf1-c98a-41cd-92cd-5a62e49cea91

## Sobre o projeto

### CI/CD

No projeto estamos utilizando no CI/CD o Bitrise para automatizar os seguintes processos:
- Validações de testes unitários
- Verificação de build
- Lint para manter o padrão de código
- Bloqueio nos MRs que o build falhar. 

link do Bitrise - https://app.bitrise.io/app/9162a1db-99da-4603-a88a-55f1c91759a2

<img width="920" alt="Captura de Tela 2024-08-05 às 17 36 35" src="https://github.com/user-attachments/assets/3ba4f303-c8b2-4a39-81e6-f2220fd75b57">

### Padrões do Git e GitHub

#### Git
Estamos seguindo um padrão simples de commit e nomes de branchs, por exemplo:

- Commit: [TASK NUMBER] ([change]): [about your change]
![Captura de Tela 2024-08-05 às 17 43 33](https://github.com/user-attachments/assets/80d1fd51-89ba-4064-9424-2391818794f4)

- Branch: [type]/[TASK NUMBER]-about-your-change
<img width="879" alt="Captura de Tela 2024-08-05 às 17 46 19" src="https://github.com/user-attachments/assets/acd6a936-6433-489f-a188-66aa8b03ebf4">

#### GitHub

- MRs: Seguimos um padrão de MR template, com o preenchimento de informações sobre o seu MR. Assim facilitando o Code review.
<img width="805" alt="Captura de Tela 2024-08-05 às 17 49 41" src="https://github.com/user-attachments/assets/ccae72a3-1173-4fb3-90a2-dfb940ed6530">

### Design Sytem

O projeto está seguindo um esquema de Design Sytem com paleta de cores do Rick and Morty, tipografia e componentes padronizados para reutilização. Outro fato importante é que o design system do projeto está modularizado e separado por packges, você pode ver na imagem a seguir:

![Captura de Tela 2024-08-05 às 17 53 58](https://github.com/user-attachments/assets/feb2c14d-1223-4473-baf0-0d047ca82efa)

#### Paleta de cores
![Subcabeçalho 1](https://github.com/user-attachments/assets/fbd21913-3757-4138-9667-cc84f4883a88)

## Próximos passos do projeto
- Finalizar todas as features
- Aumentar a cobertura de testes
