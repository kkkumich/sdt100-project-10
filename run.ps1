param([Parameter(Mandatory=$true)][string]$MainClass,[string]$Jdk="$env:USERPROFILE\.jdks\ms-21.0.12.1")
$ErrorActionPreference='Stop'
Set-Location -LiteralPath $PSScriptRoot
$sourceFiles=@(Get-ChildItem -LiteralPath 'src' -Recurse -Filter '*.java' | ForEach-Object FullName)
New-Item -ItemType Directory -Path 'build' -Force | Out-Null
& (Join-Path $Jdk 'bin\javac.exe') -encoding UTF-8 -d build @sourceFiles
if($LASTEXITCODE -ne 0){throw 'Compilation failed'}
& (Join-Path $Jdk 'bin\java.exe') -cp build $MainClass
