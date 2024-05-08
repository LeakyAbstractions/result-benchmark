
[![Latest Report][BADGE_TIMES_FASTER]][TIMES_FASTER]

# Result Library Benchmarks

This project contains some benchmarks for the [Result Library for Java][RESULT].

You may want to visualize [the latest report][BENCHMARK].


## Benchmark Scenarios

There are simple and complex scenarios to compare performance when using results versus when using exceptions.


### Simple Scenarios

The first scenarios compare the most basic usage: a method that returns a `String` or fails, depending on a given `int` parameter:

#### Using Exceptions

```java
public String usingExceptions(int number) throws SimpleException {
  if (number < 0) {
    throw new SimpleException(number);
  }
  return "ok";
}
```

#### Using Results

```java
public Result<String, SimpleFailure> usingResults(int number) {
  if (number < 0) {
    return Results.failure(new SimpleFailure(number));
  }
  return Results.success("ok");
}
```

### Complex Scenarios

The next scenarios do something a little bit more elaborate: a method invokes the previous method to retrieve a `String`; if successful, then converts it to upper case; otherwise transforms the "simple" error into a "complex" error.

#### Using Exceptions

```java
public String usingExceptions(int number) throws ComplexException {
  try {
    return simple.usingExceptions(number).toUpperCase();
  } catch (SimpleException e) {
    throw new ComplexException(e);
  }
}
```

#### Using Results

```java
public Result<String, ComplexFailure> usingResults(int number) {
  return simple.usingResults(number)
    .map(String::toUpperCase, ComplexFailure::new);
}
```


## Getting Started

> [!IMPORTANT]
>
> The report you can see [here][BENCHMARK] was generated on a [GitHub-hosted runner][GITHUB_HOSTED_RUNNER] using the latest [Ubuntu][UBUNTU_RUNNER] image and the latest [Azul Zulu OpenJDK][AZUL_ZULU_OPENJDK] version.
> Performance measurements may vary depending on different factors such as architecture, operating system, or Java virtual machine.
> Please remember that you should run your own benchmarks to make informed decisions for your specific project.

To run the [JMH benchmarks][JMH] locally, execute this command:

```sh
./gradlew jhm
```

Once they are complete, a report will be generated automatically by [JMH Visualizer][JMH_VISUALIZER].

```sh
start ./benchmark/build/reports/jmh/index.html
```


## Author

Copyright 2024 [Guillermo Calvo][AUTHOR].

[![][GUILLERMO_IMAGE]][GUILLERMO]


## License

This library is licensed under the *Apache License, Version 2.0* (the "License");
you may not use it except in compliance with the License.

You may obtain a copy of the License at <http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software distributed under the License
is distributed on an "AS IS" BASIS, **WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND**, either express or implied.

See the License for the specific language governing permissions and limitations under the License.


**Permitted:**

- **Commercial Use**: You may use this library and derivatives for commercial purposes.
- **Modification**: You may modify this library.
- **Distribution**: You may distribute this library.
- **Patent Use**: This license provides an express grant of patent rights from contributors.
- **Private Use**: You may use and modify this library without distributing it.

**Required:**

- **License and Copyright Notice**: If you distribute this library you must include a copy of the license and copyright
  notice.
- **State Changes**: If you modify and distribute this library you must document changes made to this library.

**Forbidden:**

- **Trademark use**: This license does not grant any trademark rights.
- **Liability**: The library author cannot be held liable for damages.
- **Warranty**: This library is provided without any warranty.


[AUTHOR]:                       https://github.com/guillermocalvo/
[AZUL_ZULU_OPENJDK]:            https://github.com/actions/setup-java?tab=readme-ov-file#azul-zulu-openjdk
[BADGE_TIMES_FASTER]:           https://img.shields.io/endpoint?url=https://dev.leakyabstractions.com/result-benchmark/badge.json
[BENCHMARK]:                    https://dev.leakyabstractions.com/result-benchmark/
[GITHUB_HOSTED_RUNNER]:         https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners/about-github-hosted-runners#using-a-github-hosted-runner
[GUILLERMO]:                    https://guillermo.dev/
[GUILLERMO_IMAGE]:              https://guillermo.dev/assets/images/thumb.png
[JMH]:                          https://openjdk.org/projects/code-tools/jmh/
[JMH_VISUALIZER]:               https://github.com/jzillmann/jmh-visualizer/
[RESULT]:                       https://dev.leakyabstractions.com/result/
[TIMES_FASTER]:                 https://dev.leakyabstractions.com/result-benchmark/
[UBUNTU_RUNNER]:                https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners/about-github-hosted-runners#standard-github-hosted-runners-for-public-repositories
