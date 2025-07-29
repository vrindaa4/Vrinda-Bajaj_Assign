# GitHub Repository Setup Guide

## Step 1: Create a GitHub Repository

1. Go to [GitHub.com](https://github.com) and sign in to your account
2. Click the "+" icon in the top right corner and select "New repository"
3. Fill in the repository details:
   - **Repository name**: `bajaj-springboot-project`
   - **Description**: `Spring Boot Webhook Service Application`
   - **Visibility**: Public
   - **Initialize with README**: Unchecked (we already have one)
   - **Add .gitignore**: Unchecked (we'll create our own)
   - **Choose a license**: MIT License (recommended)

## Step 2: Initialize Git Repository Locally

Run these commands in your project directory:

```bash
# Initialize git repository
git init

# Create .gitignore file
cat > .gitignore << 'EOF'
# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

# IDE
.idea/
*.iml
*.ipr
.project
.classpath
.settings/
.vscode/

# OS
.DS_Store
Thumbs.db

# Logs
*.log

# Runtime
*.jar
!bajaj-1.0.0.jar
EOF

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: Spring Boot Webhook Service Application"
```

## Step 3: Connect to GitHub and Push

Replace `YOUR_USERNAME` with your actual GitHub username:

```bash
# Add remote origin
git remote add origin https://github.com/YOUR_USERNAME/bajaj-springboot-project.git

# Push to GitHub
git branch -M main
git push -u origin main
```

## Step 4: Upload JAR File

Since the JAR file is large, you have two options:

### Option A: Include JAR in Repository (Easier)
```bash
# Add the JAR file specifically
git add target/bajaj-1.0.0.jar -f
git commit -m "Add executable JAR file"
git push
```

### Option B: Use GitHub Releases (Recommended)
1. Go to your repository on GitHub
2. Click "Releases" → "Create a new release"
3. Tag version: `v1.0.0`
4. Release title: `Bajaj Spring Boot Application v1.0.0`
5. Description: Add release notes
6. Attach the JAR file: `target/bajaj-1.0.0.jar`
7. Click "Publish release"

## Step 5: GitHub Repository Links

After completing the above steps, your repository will be available at:

- **Repository URL**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project`
- **Clone URL**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project.git`
- **JAR Download URL** (if using releases): `https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar`
- **RAW JAR URL** (if committed to repo): `https://github.com/YOUR_USERNAME/bajaj-springboot-project/raw/main/target/bajaj-1.0.0.jar`

## Step 6: Update README

Update your README.md with the actual GitHub URLs once the repository is created.

## Example Commands for Users

Once your repository is public, users can:

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/bajaj-springboot-project.git
cd bajaj-springboot-project

# Run the application directly from JAR
java -jar target/bajaj-1.0.0.jar

# Or build from source
mvn clean package
java -jar target/bajaj-1.0.0.jar
```

## Download JAR Directly

Users can download the JAR file directly using curl or wget:

```bash
# Download from releases (recommended)
wget https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar

# Or download from raw GitHub link
curl -LO https://github.com/YOUR_USERNAME/bajaj-springboot-project/raw/main/target/bajaj-1.0.0.jar
```

## Verification

To verify the JAR works:
```bash
java -jar bajaj-1.0.0.jar
# Then test: curl http://localhost:8080/health
```
