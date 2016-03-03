# EntProject


This is the Primary repository for the SWEN-343 class project.


Feel free to update any documentation/information in this repository for your project as you see fit. 


If you do not have the appropriate permissions for this repository, please contact your instructor/TA.

## Version Control Process

TODO

## Database Modifcation Process

There will be a [liquibase](http://www.liquibase.org/) file to control changes to the database in order to support an ability to easily roll back and track all modifications as we develop.  PRs will be used to simulate a CCB.  The process is as follows:

1. **Change the Liquibase File** - Commit and push the proposed changeset to the liquibase file on your team's branch.
2. **Open a PR** - The team must open a PR with the proposed changes that will serve as the formal request.  Feel free to @ mention any database coordinators or relevant developers on the PR and make sure to give a comprehensive description of why you need to make the change.  
3. **Always Remember to Comment on PRs** - Any developer is highly encouraged to make comments on any PRs before they are merged.  These comments will need to be adressed before a merge will be allowed.
4. **Get Database Coordinator Approval** - Once two database coordinators have expressed their apporoval via a comment on the PR, it is free to be merged by a database coordinator (typically the second one to give approval should go ahead and merge, but if they do not feel comfortable merging themselves, they can delegate to another database coordinator via @ mentions).
5. **Database Coordinator Makes the Change** - Once the PR is merged, the database coordinator that merged the PR can run the liquibase script to make the change to the database and ping the original developer to let them know that the change has been set.
