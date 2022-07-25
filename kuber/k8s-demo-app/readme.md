# 2. Install Minikube to work with the Kubernetes cluster
## Install kubernetes cli
brew install kubectl
## Then test it worked
kubectl version --client
## Install minikube
brew install minikube
## Start minikube:
minikube start
## If you already have kubectl installed, you can now use it to access your shiny new cluster
kubectl get pod -A
## Kubernetes Dashboard for managing your cluster
minikube dashboard

curl localhost:8080


./mvnw spring-boot:build-image

./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=localhost:5000/apps/demo

./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=pcdinh/demo-kube-app:1.0

docker tag k8s-demo-app:0.0.1-SNAPSHOT pcdinh/demo-kube-app:1.0

docker push pcdinh/demo-kube-app:1.0



$ minikube ssh

docker@minikube:~$ curl 127.0.0.1:5000
curl: (7) Failed to connect to 127.0.0.1 port 5000: Connection refused

# setup
# =====
# You did not setup the registry.
# Let's try to setup it.
docker@minikube:~$ docker run --restart=always -d -p 5000:5000 --name registry registry:2

# test
# ====
# test the registry using the following commands
docker@minikube:~$ curl 127.0.0.1:5000

docker@minikube:~$ curl 127.0.0.1:5000/v2
<a href="/v2/">Moved Permanently</a>.

docker@minikube:~$ curl 127.0.0.1:5000/v2/_catalog
{"repositories":[]}
# it's successful

docker@minikube:~$ exit
logout

make sure registry had run

docker run -d -p 5000:5000 --restart=always --name registry registry:2


kubectl create deployment k8s-demo-app --image localhost:5000/apps/demo -o yaml --dry-run=client > k8s/deployment.yaml

kubectl create service clusterip k8s-demo-app --tcp 80:8080 -o yaml --dry-run=client > k8s/service.yaml

kubectl -n develop apply -f ./k8s

kubectl create deployment student-client --image  -o yaml --dry-run=client > k8s/deployment.yaml

kubectl create service clusterip k8s-demo-app --tcp 80:8080 -o yaml --dry-run=client > k8s/service.yaml



expose
kubectl patch service k8s-demo-app -p '{"spec": {"type": "LoadBalancer", "externalIPs":["172.18.0.2"]}}'
kubectl port-forward -n develop service/k8s-demo-app 8080:80