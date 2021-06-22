# tearsdown voting app from kubernetes cluster
kubectl delete service redis
kubectl delete service db
kubectl delete service result-service
kubectl delete service voting-service

kubectl delete deployment worker-app-deploy
kubectl delete deployment redis-deploy
kubectl delete deployment postgres-deploy
kubectl delete deployment voting-app-deploy
kubectl delete deployment result-app-deploy
