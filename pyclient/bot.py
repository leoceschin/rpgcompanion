import os

import discord
from discord.ext import commands
import requests
import json
from dotenv import load_dotenv

load_dotenv('./config/.env')
TOKEN = os.getenv('DISCORD_TOKEN')

BASE_URL='http://localhost:8081/'

intents = discord.Intents.default()
intents.members = True
intents.message_content = True


#client = discord.Client(intents=intents)

bot = commands.Bot(command_prefix='!rpg ', intents=intents)

@bot.event
async def on_ready():
    print(f'{bot.user} has connected to Discord!')

@bot.command()
async def oi(ctx):
    await ctx.send("oi")

@bot.command()
async def gameinit(ctx):
    id = ctx.message.channel.id
    """
        Inicia o jogo
    """
    r = requests.post(BASE_URL+"game-init/"+str(id))
    if (r.status_code == 200):
        await ctx.send("Jogo iniciado")

@bot.command()
async def addplayer(ctx, name: str, life: int):
    payload = {
        "id": ctx.message.author.id,
        "name": name,
        "chatId": ctx.message.channel.id,
        "lifePoints": life
    }
    r = requests.post(BASE_URL+"add-player", json=payload)
    await ctx.send("personagem adicionado")

@bot.command()
async def adddamage(ctx, name: str, diceRaw: str, attr=0):
    dice = diceRaw.split('d')
    sides = int(dice[1])
    quantity = int(dice[0])
    
    payload = {
        "chatId": ctx.message.channel.id,
        "name": name,
        "sides": sides,
        "quantity": quantity,
        "attributes": attr
    }
    r = requests.put(BASE_URL+"add-damage", json=payload)
    await ctx.send(r.content)

@bot.command()
async def roll(ctx, diceRaw: str, attr=0, name="",):
    dice = diceRaw.split('d')
    sides = int(dice[1])
    quantity = int(dice[0])
    
    payload = {
        "chatId": ctx.message.channel.id,
        "name": name,
        "sides": sides,
        "quantity": quantity,
        "attributes": attr
    }
    r = requests.get(BASE_URL+"roll", json=payload)
    await ctx.send(r.content)

bot.run(TOKEN)