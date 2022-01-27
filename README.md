# Overview
Learning Spark. Note about Spark

# Deployment 

### Deploy a local Spark cluster using `docker-compose` 
``` bash
docker-compose up 
```

### Scale worker
```bash
docker-compose scale spark-worker=<N>
```

# Build Spark application & submit to docker-compose Spark cluster

### Compile and build jar package
```bash
sbt package
```

### Submit application
```bash
# Go to spark-workspace container (proxy container)
docker exec -it $(docker ps --filter name=spark-workspace --format={{.ID}}) /bin/bash

# Submit application
spark-submit --class "ClassName" --master master_url jar_file
```
