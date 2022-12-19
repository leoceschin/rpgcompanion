# RPG Discord Bot
Um bot para auxiliar seu game de RPG no Discord.

## Servidor
Api para salvar status dos jogadores, rolagem de dados e danos.
Feito usando Spring Boot

## Cliente
Bot do discord feito com nodeJS, consumindo e enviando dados para a api

## Funcionamento

### Inicio
No inicio o mestre envia o comando "!rpg init" para iniciar uma nova partida.
Após o comando, cada jogador deverá enviar seu nome e a quantidade de vida de cada um.
A mensagem precisa ser enviada com o prefixo "!rpg" seguido do comando e os argumentos caso sejam necessários.
Ex:
```
!rpg addPlayer Jailson 23
```
| comando | uso |
|---------|-----|
| !rpg | prefixo |
| addPlayer | comando |
| Jailson | nome do jogador |
| 23 | Pontos de vida |

### Rolagem de dados
Para rolar os dados o comando a seguir deve ser usado.
````
!rpg roll 2d6 10
```
| comando | uso |
|---------|-----|
| !rpg | prefixo |
| roll | comando |
| 2d6 | 2(quantidade de rolagens) x d6(tipo do dado) |
| 10 | Pontos adicionais |

### Adicionar dano
Para adicionar dano a um personagem utilize o seguinte comando
```
!rpg addDamage Jailson 2d6 3
```
| comando | uso |
|---------|-----|
| !rpg | prefixo |
| addDamage | comando |
| JJailson | nome do player |
| 2d6 | 2(quantidade de rolagens) x d6(tipo do dado) |
| 3 | Pontos adicionais |
