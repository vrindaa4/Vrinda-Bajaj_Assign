#!/bin/bash

# Bajaj Spring Boot Project - Git Setup Script
# This script initializes the git repository and prepares it for GitHub

echo "🚀 Setting up Git repository for Bajaj Spring Boot Project..."

# Initialize git repository
echo "📁 Initializing Git repository..."
git init

# Add all files
echo "📦 Adding files to Git..."
git add .

# Create initial commit
echo "💾 Creating initial commit..."
git commit -m "Initial commit: Spring Boot Webhook Service Application

Features:
- Spring Boot 3.3.0 with Java 22 support
- Webhook service with REST endpoints
- Health check endpoint
- Error handling for external API calls
- Comprehensive unit and integration tests
- Executable JAR file (19MB)

Endpoints:
- GET /health - Application health check
- POST /execute - Execute webhook flow

JAR file: target/bajaj-1.0.0.jar (19MB)"

echo "✅ Git repository initialized successfully!"
echo ""
echo "📌 Next steps:"
echo "1. Create a new repository on GitHub named 'bajaj-springboot-project'"
echo "2. Run: git remote add origin https://github.com/YOUR_USERNAME/bajaj-springboot-project.git"
echo "3. Run: git branch -M main"
echo "4. Run: git push -u origin main"
echo "5. Create a release and upload the JAR file for easy download"
echo ""
echo "📦 JAR file location: target/bajaj-1.0.0.jar ($(ls -lh target/bajaj-1.0.0.jar | awk '{print $5}')")
