#!/bin/sh

set -xa


setup_user() {
    kubectl create clusterrolebinding owner-cluster-admin-binding \
    --clusterrole cluster-admin \
    --user $USER
}

clone_gits() {
    git clone https://github.com/bibinwilson/kubernetes-prometheus & \
    git clone https://github.com/devopscube/kube-state-metrics-configs.git
}

apply_all() {
    kubectl create namespace monitoring
    for file in $(ls kubernetes-prometheus/*.yaml)
    do
        kubectl apply -f $file --namespace=monitoring
    done
    for file in $(ls kube-state-metrics-configs/*.yaml)
    do
        kubectl apply -f $file
    done
    for file in $(ls *.yaml)
    do
        kubectl apply -f $file
    done
}


clone_gits
setup_user
apply_all