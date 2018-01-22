#! /bin/env bash

envsubst </tmp/config.js.template >/usr/share/nginx/html/config.js

nginx -g "daemon off;"
