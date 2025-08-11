### Go, Springboot, Fastapi, django(apiserver)

### CI/CD
- Automated GitHub Releases on push to `main`
- Docker image tagging with both:
  - `latest`
  - Timestamp version (e.g. `v2025.07.25.143210`)
- Manual deployment to EC2 via SSH + Docker (triggered from GitHub Actions)
- Jira integration: Commits containing Jira issue keys (e.g. `TESTPROJ-6`) automatically transition issues to "Done" status


[![](https://img.shields.io/badge/release-latest-critical?style=flat&logo=github&logoColor=balck&labelColor=black&color=white)
](https://github.com/xxng1/test-server/releases)
