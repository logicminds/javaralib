
Summary  
========
This is a proof of concept to port the actionscript based RemoteAdmin mobile client to a Native Android App.
This repo will contain just the library to process all http queries with respect to Foreman and PuppetDB.
The goal is to marshal the data received from both sources to a common model.

Goals
=============
1. Build a development foreman server in AWS
2. Build a development puppetDB server in AWS
3. Build a jenkins development environment in AWS or use hosted version


Getting Started:
================
Requirements for Development
-----------------------------
1. STS 3.1 Release or Eclipse 4.1.2+
2. spring-android (included in POM file)
3. maven android plugin (http://code.google.com/p/maven-android-plugin/)
4. m2e android connector (http://rgladwell.github.com/m2e-android/)
5. android development tools (SDK)
6. A github account

How to run
==================
Doesn't compile yet, still in initial design phase. In fact the name of this repo may change. 

License:
=========
GPL v3

Developers:
============
Corey Osman <corey@logicminds.biz>


Contributing:
=================
1. Open a ticket or feature request in this github repo
    You will want to reference it in your commit message. (This is very helpful when generating release notes.)
2. Fork this repo http://www.github.com/logicminds/javaralib to your personal github account
    Help here: https://help.github.com/articles/fork-a-repo
3. You Should end up with a repo of <username>/javaralib
4. Clone personal foreman fork to local system
    git clone https://github.com/<username>/javaralib.git
5. Reference logicminds/javaralib as upstream
6. cd </path/to/local/javaralib/git/repo>
7. git remote add upstream https://github.com/logicminds/javaralib.git
8. git fetch
9. Create a feature/topic branch
10. git checkout -b <branchName>
    Example: git checkout -b 1656-add_more_tests_for_android
11. Make changes and commit
12. git add <modifiedFile(s)>; git commit -m 'fixes #<bug> <message>'
    Please reference the github ticket with this commit addresses via "refs" or "fixes" #issueid in the commit message
13. Push topic branch to your fork
14. git push origin <branchName>
    Example: git push origin 1656-add_more_tests_for_android
15. Issue a pull request
    https://help.github.com/articles/using-pull-requests

Once you have followed this process once, it becomes much simpler to add future patches!

Merge upstream develop to local develop
========================================
In order to get the latest upstream code use the following workflow.

1. git fetch upstream
2. git checkout develop
3. git rebase upstream/develop develop
4. git push origin develop
5. Now follow step 5 to the end from the contributing workflow above.

