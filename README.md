# lab2-trspo<br>
### Docker:
1. Create docker images of services: *__docker build -t dockerID/service-name:latest .__*
2. Push docker images to our Docker hub: *__docker push dockerID/service-name__*

### Minikube: 
1. To start in minikube: *__minikube start --driver=docker --ports=30000:30000,30001:30001,30002:30002__*
2. Start images from temrinal: *__kubectl apply -f service-name.yaml__*
