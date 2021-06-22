#!/bin/bash

# builds voting app on kubernetes from backend to front end order
# create namespace for application
#kubectl create namespace voting-app

# build worker
kubectl apply -f deployments/worker-app-deploy.yaml

# build redis
kubectl apply -f deployments/redis-deploy.yaml
kubectl apply -f services/redis-service.yaml

# build postgres
kubectl apply -f deployments/postgres-deploy.yaml
kubectl apply -f services/postgres-service.yaml

# build result-app
kubectl apply -f deployments/result-app-deploy.yaml
kubectl apply -f services/result-app-service.yaml

# build voting-app
kubectl apply -f deployments/voting-app-deploy.yaml
kubectl apply -f services/voting-app-service.yaml