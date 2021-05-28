
###Client APP
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=pcdinh/kube-demo-client

docker push pcdinh/kube-demo-client

kubectl create deployment student-client --image pcdinh/kube-demo-client:1.0 -o yaml --dry-run=client > k8s/deployment.yaml
kubectl create service clusterip student-client --tcp 80:8081 -o yaml --dry-run=client > k8s/service.yaml


kubectl delete -f ./k8s
kubectl apply -f ./k8s

kubectl logs <service-name>

kubectl port-forward service/student-client 8082:81


kubectl create clusterrolebinding default-admin --clusterrole cluster-admin --serviceaccount=default:default
