const { Client } = require("discord.js");
const config = require("./config.json");

const client = new Client({intents: [ "GUILDS", "GUILD_MESSAGES" ]});
const prefix = "!rpg"

client.on("messageCreate", (message) =>  { 
    if(message.author.bot) return;

    if (!message.content.startsWith(prefix)) return;

    const commandBody = message.content.slice(prefix.length);
    const args = commandBody.split(' ');
    const command = args.shift().toLowerCase();

    


});

client.login(config.BOT_TOKEN);