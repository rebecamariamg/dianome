#!/bin/bash

# Wait for MySQL service to be ready
echo "Waiting for MySQL..."
sleep 50

# MySQL should be ready
echo "MySQL is up..."
echo "Starting spring..."
exec "$@"