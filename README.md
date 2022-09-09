# Microservices with Kubernetes

The proposal of this repository is just learning about microservices with Kubernetes using:

- Ingress
- HPA
- Deployments
- Liveness
- Config Maps
- Persistent Volumes

For all projects is used Java 17 and to build container images is used maven plugin called "jib", this plugin build the docker image and automatically push to the image register. To apply services, just run the `pg-deployment.yml` and `user-deployent.yml` with command `kubectl apply -f others-deploy/pg-deployment.yml && kubectl apply -f others-deploy/user-deployment.yml`. Apply deployments inside every `-api` folder, after do this apply `gateway-deployment.yml`. In your hosts file add the line `ingress-ip shopping.com`. Import [request collection](./thunder-collection_java-microservices-with-kubernetes.json) to your Thunder Client, or other http tool and just do it. 