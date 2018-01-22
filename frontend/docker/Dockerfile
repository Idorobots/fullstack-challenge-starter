FROM nginx:1.11
MAINTAINER "Kajetan Rzepecki <k@idorobots.org>"

ADD docker/nginx.conf /etc/nginx/conf.d/default.conf
ADD docker/config.js.template /tmp/config.js.template
ADD docker/run.sh /
ADD dist /usr/share/nginx/html

CMD bash run.sh
