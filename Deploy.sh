mvn clean install
sudo docker build -t fibonacci:latest .
sudo docker run -it --network=host -d fibonacci:latest
