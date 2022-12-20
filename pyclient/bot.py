import os

import discord
from discord.ext import commands
import requests
from dotenv import load_dotenv

load_dotenv()
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
        
bot.run(TOKEN)