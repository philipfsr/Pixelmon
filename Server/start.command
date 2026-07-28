#!/bin/zsh
cd "$(dirname "$0")"

java -Xms4G -Xmx8G -jar server.jar nogui
