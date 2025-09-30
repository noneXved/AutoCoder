# AutoCoder

description: |
  Autocoder Bot is a composite GitHub Action designed to automate the process of generating production-ready code 
  from issue descriptions using OpenAI's ChatGPT API. When triggered by issues labeled with a customizable label, 
  this action fetches the issue content, sends it to ChatGPT for intelligent code generation, and receives a JSON 
  object mapping file paths to code snippets. It then commits these generated files back to the repository in a 
  dedicated branch and opens a pull request for easy integration. 

  The action simplifies the software development workflow by bridging natural language issue descriptions and 
  working code generation, reducing manual effort and accelerating delivery. 

  It requires a valid GitHub personal access token with repository access and an OpenAI API key for communicating 
  with the ChatGPT service. Inputs allow customization of the trigger label and script path. 

  This action is ideal for teams looking to harness AI for automating routine coding tasks directly from GitHub issues.

```
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
