#!/bin/sh
set -ex
url=$1
browser_name=$2
feature_file_path=$3
testng_runner_file="TestNg.xml"

run_scenarios() {
  mvn -Dmaven.artifact.threads=30 compile verify -Dsurefire.suiteXmlFiles="$1" -Denv.url="$url" -Dbrowser="$browser_name" -Dcucumber.features="$2"
}

cd ../..
current_dir=$(pwd)
echo "$current_dir"

if [ -z "$feature_file_path" ]; then
  echo "Running All Scenarios"
  run_scenarios $testng_runner_file "$current_dir/features"
else
  echo "Running Specific Scenarios"
  run_scenarios $testng_runner_file "$current_dir"/"$feature_file_path"
fi

if [ -s target/rerun.txt ]; then
  if [ "$(ls -A screenshots)" ]; then
    rm screenshots/*
  fi
  if [ "$(ls -A screenshotdiff)" ]; then
    rm -rf screenshotdiff/*
  fi
  run_scenarios "Rerunner.xml" @target/rerun.txt
fi
