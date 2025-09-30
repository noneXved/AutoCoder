# AutoCoder

This repository to store the configuration files for GitHub Actions and the scripts to interact with ChatGPT.
The repository will be public, allowing anyone to access it.

name: Run Autocoder Bot on issue labeled

on:
  issues:
    types: [opened, reopened, labeled]

jobs:
  autocoder_job:
    if: contains(github.event.issue.labels.*.name, 'autocoder-bot')
    runs-on: ubuntu-latest
    steps:
      - name: Run Autocoder Bot
        uses: yourusername/your-repo@v1.0.0
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          REPOSITORY: ${{ github.repository }}
          ISSUE_NUMBER: ${{ github.event.issue.number }}
          OPENAI_API_KEY: ${{ secrets.OPENAI_API_KEY }}
          SCRIPT_PATH: scripts/script.sh
          LABEL: autocoder-bot

```
AutoCoder/                       # Root directory of the project
    │
    ├── .github/                 # Hidden directory for GitHub-specific files
    │   └── workflows/           # Directory for GitHub Actions workflow files
    │       └── main.yml         # Contains workflow file main.yml (empty for now)
    │
    ├── scripts/                 # Directory for custom scripts
    │   └── script.sh            # Bash script to interact with ChatGPT (empty for now)
    │
    └── README.md                # Project description file
```
