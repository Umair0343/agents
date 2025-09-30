## Contract Guardian

Cross-repo contract enforcement for OpenAPI/GraphQL/Protobuf/JSON Schema. Detects breaking changes, validates client repos, generates contract tests, attempts targeted fixes, and can open PRs.

### Why
- Prevent silent API breaks across services and consumers
- Automate SDK bumps and small refactors
- Provide CI-enforceable reports and PR automation

### Features
- Breaking change detection (OpenAPI/GraphQL/Protobuf/JSON Schema)
- Cross-repo scanning via local workspaces or Git URLs
- Client validation (type checks/builds where feasible)
- Optional contract test generation
- Automated PRs with templated descriptions

### Prerequisites
- Node.js 18+
- Qodo Command
- GitHub CLI (`gh`) and `GITHUB_TOKEN` for PRs

### Install Qodo Command
```bash
npm install -g @qodo/command
```

### Run Locally (single repo)
```bash
qodo contract-guardian \
  --agent-file=agents/contract-guardian/agent.toml \
  --service_repo=. \
  --contract_path=openapi.yaml \
  --mode=analyze
```

### Cross-Repo Run (multiple clients)
```bash
qodo contract-guardian \
  --agent-file=agents/contract-guardian/agent.toml \
  --service_repo=https://github.com/org/service-a.git \
  --client_repos=https://github.com/org/web-app.git,https://github.com/org/mobile-app.git \
  --contract_path=openapi.yaml \
  --mode=update \
  --dry_run=false
```

### CI Mode (fail on breaking changes)
```bash
qodo contract-guardian \
  --agent-file=agents/contract-guardian/agent.toml \
  --service_repo=. \
  --contract_path=openapi.yaml \
  --mode=ci
```

### Environment
- `GITHUB_TOKEN` to create PRs

### Notes
- This agent orchestrates detection and automation via MCP `shell`, `git`, and `github` tools. It does not assume a specific language/build system and uses project scripts when present.


