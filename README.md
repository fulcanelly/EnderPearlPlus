![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/fulcanelly/EnderPearlPlus/total)
![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/fulcanelly/EnderPearlPlus/main.yml)

## EnderPearlPlus

EnderPearlPlus is the Spigot plugin that aims to fix problem - [ender pearl bug](https://bugs.mojang.com/browse/MCPE-55823).
That bug causes ender pearls to "forget" their owner if the player exits and re-enters the game while the pearl is in mid-air. As a result, when the ender pearl eventually lands, it fails to teleport the player, breaking the expected gameplay mechanic.

### Motivation 
Since this plugin helps ender pearls remember it's owner

This could be valuable for SMP servers aiming to maintain a vanilla experience while providing players advanced travel options.

Specifically I mean ender pearl chamber 
![image](https://github.com/fulcanelly/EnderPearlPlus/assets/53056797/afd0ed24-acfe-4fda-8cf1-c8a197231090)

As a bonus it's adds ability to customize ender pearl behaviour such as allowing teleporting from other worlds


### How to install ?


* Download [Rtag](https://www.spigotmc.org/resources/rtag-api-to-edit-block-entity-item-nbt-1-8-8-1-20-4.100694/) and put it in your server's `plugins` folder

* Download appropriate version of `EnderPearlPlus` [resource](https://github.com/fulcanelly/EnderPearlPlus/releases) and put it into `plugins` folder

### Planned / todo (seeking for help, have no eought time)
* Get use of papermc's EntityRemoveFromWorldEvent to handle dropping pearl to void
* Get list of all thrown pearls and distance to them
* Make offline tp configurable 
