# EntProject


This is the Primary repository for the SWEN-343 class project.


Feel free to update any documentation/information in this repository for your project as you see fit. 


If you do not have the appropriate permissions for this repository, please contact your instructor/TA.

## Version Control Process

1. **Merge Into Your Team Branch** - Make changes to the code and submit those changes to your team's branch (allowing your team to review the changes first).
2. **Open a PR** - Open a PR into master.
3. **Get Approval** - In order for the PR to be merged, every other team must have at least one member review and approve the PR by simply commenting a :thumbs_up: or some message of approval.  The version control managers of each team will be in charge of ensuring that someone on their team reviews the PR.  This will ensure that we should never encounter the "someone will take care of it" deadlock on a PR since all teams will have a particular representative that is in charge of making sure all PRs are reviewed in a timely manor. 
4. **Rework If Needed** - If a reviewer suggests that changes be made, they should be discussed and revised as necessary.  Once the changes are made and the proper number of people have approved the PR, it can be merged.
5. **Merge The PR** - Once approval has been reached, the Team Coordinator for the team that proposed the PR can then merge it and deploy the change onto the server.

## Database Modifcation Process

There will be a [liquibase](http://www.liquibase.org/) file to control changes to the database in order to support an ability to easily roll back and track all modifications as we develop.
