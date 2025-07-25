### Go, Springboot, Fastapi, django(apiserver)

### CI/CD
- Automated GitHub Releases on push to `main`
- Docker image tagging with both:
  - `latest`
  - Timestamp version (e.g. `v2025.07.25.143210`)
- Manual deployment to EC2 via SSH + Docker (triggered from GitHub Actions)
