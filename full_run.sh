#! /bin/bash

docker-compose down
./docker_cleanup.sh > /dev/null
./prepare.sh
#./dump.sh
#./generate.sh
#./dump.sh
