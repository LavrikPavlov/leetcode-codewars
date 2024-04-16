FROM ubuntu:latest
LABEL authors="mihailkazan"

ENTRYPOINT ["top", "-b"]