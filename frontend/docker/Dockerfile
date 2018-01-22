FROM nginx:1.11
MAINTAINER "Kajetan Rzepecki <k@idorobots.org>"

ADD docker/nginx.conf /etc/nginx/conf.d/default.conf
ADD dist /usr/share/nginx/html

CMD nginx -g "daemon off;"
