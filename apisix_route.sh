#!/usr/bin/env bash

# create account-service route 00000000000000000026
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/account-service/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9050": 1
#        },
#        "type": "roundrobin"
#    }
#}'

## update account-service route
#curl -XPUT http://localhost:9180/apisix/admin/routes/00000000000000000162 \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/account-service/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9050": 1
#        },
#        "type": "roundrobin"
#    }
#}'


# create developer-service route 00000000000000000707
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/developer/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "plugins": {
#        "ext-plugin-pre-req": {
#            "conf": [
#                {
#                    "name": "AppRewriteRequestRealmFilter",
#                    "value": "{\"MY_PLUGIN_CONFIG_PARAMS\":\"MY_PLUGIN_CONFIG_PARAMS_VALUE\"}"
#                }
#            ]
#        }
#    },
#    "upstream": {
#        "nodes": {
#            "localhost:9080": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# create developer-company-1 route 00000000000000000024
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/developer-company-1/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9040": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# create developer-company-2 route 00000000000000000022
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/developer-company-2/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9041": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# update developer-company-1 route 00000000000000000169
#curl -XPUT http://localhost:9180/apisix/admin/routes/00000000000000000169 \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/developer-company-1/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9040": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# update developer-company-2 route 00000000000000000547
#curl -XPUT http://localhost:9180/apisix/admin/routes/00000000000000000547 \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/developer-company-2/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9041": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# create login route 00000000000000000020
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#	"uri": "/account-service/account/doLogin",
#	"methods": [
#		"POST"
#	],
#	"hosts": [
#		"localhost"
#	],
#	"plugins": {
#		"ext-plugin-pre-req": {
#			"conf": [{
#				"name": "DoLonginRewriteRequestRealmFilter",
#				"value": "{\"MY_PLUGIN_CONFIG_PARAMS\":\"MY_PLUGIN_CONFIG_PARAMS_VALUE\"}"
#			}]
#		}
#	},
#	"upstream": {
#		"nodes": {
#			"192.168.56.1:9050": 1
#		},
#		"type": "roundrobin"
#	}
#}'

# update login route 00000000000000000020
#curl -XPUT http://localhost:9180/apisix/admin/routes/00000000000000000020 \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/account-service/account/doLogin",
#    "methods": [
#        "POST"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "plugins": {
#        "ext-plugin-pre-req": {
#            "conf": [
#                {
#                    "name": "DoLonginRewriteRequestRealmFilter",
#                    "value": "{\"MY_PLUGIN_CONFIG_PARAMS\":\"MY_PLUGIN_CONFIG_PARAMS_VALUE\"}"
#                }
#            ]
#        }
#    },
#    "upstream": {
#        "nodes": {
#            "localhost:9080": 1
#        },
#        "type": "roundrobin"
#    }
#}'


# create software-market-company-1 route 00000000000000000016
#curl -XPOST http://localhost:9180/apisix/admin/routes \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/software-market-company-1/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9030": 1
#        },
#        "type": "roundrobin"
#    }
#}'

# update software-market-company-1 route 00000000000000000016
#curl -XPUT http://localhost:9180/apisix/admin/routes/00000000000000000016 \
#-H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" \
#-d  \
#'{
#    "uri": "/software-market-company-1/*",
#    "methods": [
#        "GET",
#        "POST",
#        "PUT",
#        "DELETE"
#    ],
#    "hosts": [
#        "localhost"
#    ],
#    "upstream": {
#        "nodes": {
#            "192.168.56.1:9030": 1
#        },
#        "type": "roundrobin"
#    }
#}'