folder('Terraform') {
    displayName('Terraform')
    description('Terraform')
}

def jobs= [
        [name : "VPC", git : "terraform-vpc"],
        [name : "DB", git : "terraform-databases" ]
]

multibranchPipelineJob('example') {

    branchSources {
        git {
            id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/pathipatireshma/terraform-vpc.git')
            includes('**')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(0)
        }
    }
}