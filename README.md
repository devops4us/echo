# echo
Openshift Echo Web Service


# Step 1: create local Docker image

From the command line, run 

``` 
mvn package
```

This will create a zipped version of the web application in the `target` directory. Next, run the below
command line. The command will create a docker image as specified in `Dockerfile`. 
The image is based on open liberty and contains the web application with the `echo` service.

```
docker build -t echo:1.0-SNAPSHOT .
```

If the build was sucessful, the following command line will result in the image `echo:1.0-SNAPSHOT` listed.

```
docker image ls
```

# Step 2: push the created image to your OpenShift image registry

To get your credentials, type 

```
oc whoami
oc whoami -t
oc registry info  
```

and then use the results from above to authenticate against the OpenShift container registry:

```
docker login -u [oc whoami] - p [oc whoami -t] [oc registry info]
```