
# CoinsAPI
Minecraft-Spigot Plugin/API 1.14.4


## German/Deutsch

**CoinsAPI**

Die CoinsAPI gibt euch die Möglichkeit ein neues Economy/Geld-System in eurem Server zu integrieren.
Für dei CoinsAPI wird eine MySQL-Datenbank benötigt.

# Für Entwickler

    getCoins(String uuid)

Gibt die Coins als int wieder.

    setCoins(String uuid, int coins)

Setzt die Coins eines Spielers.

    addCoins(String uuid, int coins)

Gibt den Spieler Coins.

    removeCoins(String uuid, int coins)

Verringert die Coins des Spielers um den angegebenen Wert.


-----------------------------------


## English / Englisch

**CoinsAPI**

You can use the CoinsAPI as an Economy-System.
For the CoinsAPI you need a MySQL-Database.

# for developer

    getCoins(String uuid)

Returns the Coins-value of the player.

    setCoins(String uuid, int coins)

Sets the Coins of the player to the value.

    addCoins(String uuid, int coins)

Add Coins to the player.

    removeCoins(String uuid, int coins)

Removes Coins from the player.
