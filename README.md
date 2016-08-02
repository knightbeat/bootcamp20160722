# Developers' Bootcamp 2016 #

**Demonstration Scenario**

**Environment Setup**
  1. To run the examples of this workshop, it is neccessary to have the following tools installed on your laptop.
     - Docker or Docker-machine
       - LINUX users need to install [Docker](https://www.docker.com/)
       - Windows and OSx user need to install [Docker-machine](https://docs.docker.com/machine/install-machine/).
  2. This README assumes that the followers may use Windows or OSx. Therefore,
     - The example docker commands are mostly provided according to Windows and OSx.
     - LINUX users can skip commands related to `docker-machine`, which are marked as `dmr`.
  3. Add a host entry to the host machine (`dmr`)
     - `docker-machine start` - will start the docker machine if you are using `windows` or `OSx`.
     - `docker-machine ip` - will display the IP address of the docker machine.
     - Open the `hosts` file of the host machine, and add an entry as `<ip-address> docker.machine`.
  2. Download WSO2 product binary packages
     - WSO2 API Manager 1.10.0 - `wso2am-1.10.0.zip`
     - WSO2 Data Analytics Server 3.0.1 - `wso2das-3.0.1.zip`
     - WSO2 Data Services Server 3.5.0 - `wso2dss-3.5.0.zip`
     - WSO2 Enterprise Service Bus 4.9.0 - `wso2esb-4.9.0.zip`
  3. Add these 4 binary packs to the `packs` directory.

**MySQL database container**

  1. Start the database container
     - `docker-compose up -d dbs` - will create the MySQL container image and boot it up.
     - This will also create all the required data tables
     - `docker ps` - lists the running container information. 
     - Observe the NAME values ( dbs.bootcamp.com ) of the containers.
     
**Microservices**

  1. Start a terminal window
  2. Go to `bootcamp20160722/mss-source/Transportation-option-service` directory
  3. Build the microservice with Maven
     - `mvn clean install`
  4. Start the relevant microservice container with Docker Quickstart terminal.
     - `docker-compose up -d trans-opt`
  5. Load the Swagger definition of the `transport-options` service.
     - [http://docker.machine:8080/swagger?path=/transport-options](http://docker.machine:8080/swagger?path=/transport-options)
  6. Try the `transport-options` service with [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
     - http://docker.machine:8080/transport-options/routes?from=KT89HA&to=SW96DE&at=1933
     - http://docker.machine:8080/transport-options/routes/LNDN00012
     - Add header `Accept` with value `application/json` and see the response.
     - Add header `Accept` with value `text/xml` and see the response.
  7. Go to `bootcamp20160722/mss-source/Transportation-costs-service` directory
  8. Build the microservice with Maven
     - `mvn clean install`
  9. Start the relevant microservice container with Docker Quickstart terminal.
     - `docker-compose up -d trans-cost`
  10. Load the Swagger definition of the `transport-cost` service.
     - [http://docker.machine:8081/swagger?path=/transport-cost](http://docker.machine:8080/swagger?path=/transport-cost)
  11. Try the `transport-cost` service with [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
     - http://docker.machine:8081/transport-cost/rail?from=Hampton&to=Vauxhall
     - http://docker.machine:8081/transport-cost/bus?from=Hampton&to=Vauxhall
     - http://docker.machine:8081/transport-cost/taxi?from=Hampton&to=Vauxhall
     - Add header `Accept` with value `application/json` and see the response.
     - Add header `Accept` with value `text/xml` and see the response.
  12. List and see running containers
    - `docker ps` - lists the running container information. 
     - Observe the NAME values ( dbs.bootcamp.com, tos.bootcamp.com, tcs.bootcamp.com ) of the containers.
  
**WSO2 Data Services Server (DSS)**

  1. Start the DSS container
     - `docker-compose up -d dss` - will create the DSS container image and boot it up.
     - `docker ps` - lists the running container information. 
     - Observe the NAME values ( dbs.bootcamp.com, tos.bootcamp.com, tcs.bootcamp.com, dss.bootcamp.com ) of the containers.
  2. Upload Artifacts
     - Tail DSS logs, and observe.
         - Run `docker exec -it dss.bootcamp.com tailf wso2/wso2dss-3.5.0/repository/logs/wso2carbon.log`
     - Open the admin management console with [https://docker.machine:9445/carbon](https://docker.machine:9445/carbon) (user=admin, password=admin).
     - Go to `Manage > Carbon Applications > Add`.
     - Upload `bootcamp20160722/artifacts/bootcamp2016072_1.0.0.car`.
     - Observe DSS logs and verify that the artifacts were deployed successfully.
  3. Open [SOAPUI](https://www.soapui.org/downloads/soapui.html), and load project  `bootcamp20160722/artifacts/Bootcamp-soapui-project.xml`.
  4. Observe operations of the Data Service.
     - CourseInformationDataService
         - Try the operations `getAllJourneyPlans`: and `getJourneyPlan` with 
           - `N02341334` as **passport** and,
           - `JNPLN002` as **plan_id**.
         
**WSO2 Enterprise Service Bus (ESB)**

  1. Start the ESB container
     - `docker-compose up -d esb` - will create the ESB container image and boot it up.
     - `docker ps` - lists the running containers information. 
     - Observe the NAME value ( esb.bootcamp.com ) of this container.
  2. Upload Artifacts
     - Tail ESB logs, and observe.
         - Run `docker exec -it esb.bootcamp.com tailf wso2/wso2esb-4.9.0/repository/logs/wso2carbon.log`
     - Open the admin management console with [https://docker.machine:9444/carbon](https://docker.machine:9444/carbon) (user=admin, password=admin).
     - Go to `Manage > Carbon Applications > Add`.
     - Upload `bootcamp20160722/artifacts/bootcamp2016072_1.0.0.car`.
     - Observe ESB logs and verify that the artifacts were deployed successfully.
  3. Start a REST client like [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
  3. Add `http://docker.machine:8281/travel/transport-options?passport=<passport_number>&plan_id=<plan_id>`
     - i.e. http://docker.machine:8281/travel/transport-options?passport=N02341334&plan_id=JNPLN002
  4. Invoke and observe the response

**WSO2 API Manager (API-M)**

  1. Start the API-M container
     - `docker-compose up -d apim` - will create the API-M and WSO2 Data Analytics Server(DAS) container images and boot them up.
     - `docker ps` - lists the running containers information. 
     - Observe the NAME value ( api.bootcamp.com ) of this container.
  2. Open API-M user interfaces (user=admin, password=admin).
     - API-M Admin Console [https://docker.machine:9443/carbon](https://docker.machine:9443/carbon)
     - API-M Publisher [https://docker.machine:9443/publisher](https://docker.machine:9443/publisher)
     - API-M Store [https://docker.machine:9443/store](https://docker.machine:9443/store)
  3. Publish the API which was created on the ESB earlier.
     - Create an API on API-M publisher.
     - Provide a proper resource path (i.e. `/travelapi`)
     - Add resource `/transport-options` with GET method.
       - Expand the added resource by clicking on `/transport-options` on the resources section
       - Add 2 query parameters as,
         - passport
         - plan_id
     - Provide `http://esb.bootcamp.com:8280/travel` as the production URL
         - In this case, communication happens directly between the API-M and ESB docker containers.
         - It does not happen accross the host machine.
         - Therefore, instead of using `docker.machine` as the hostname to contact the ESB,
         - it is neccessary to use the ESB container name `esb.dbtoapi.com` as host name.
         - When the host machine doesn't involve in communication, the docker-compose port mappings do not apply.
         - Therefore, instead of using port '8281', directly use port '8280' (ignoring the port mapping).
  4. Subscribe to the API via the API-M Store.
  5. Try the API with Swagger based API Console on the API-M Store UI.
  6. Or, use a REST client like [POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)
     - i.e. http://docker.machine:8280/travelapi/transport-options?passport=N02341334&plan_id=JNPLN002
     
**Additionally note**
  You can also expose the Microservices and Data-services endpoints (both SOAP and REST) directly through the API Manager, without making a route through the ESB installation. With Microservices, you can use the **Swagger import** option of WSO2 API Manager, in order to get all the API resources generated automatically, without manually adding them.

**When You are done...**

  1. Run `docker stop $(docker ps -a -q)` to stop all containers.
  2. Run `docker-machine stop` to stop the machine.
  
