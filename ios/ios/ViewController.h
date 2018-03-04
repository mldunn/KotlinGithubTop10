//
//  ViewController.h
//  ios
//
//  Created by Tudor Prodan on 28/02/2018.
//  Copyright © 2018 Tudor Prodan. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property (weak, nonatomic) IBOutlet UILabel *label;
@property (weak, nonatomic) IBOutlet UIButton *button;
@property (weak, nonatomic) IBOutlet UITextField *textField;
@property (weak, nonatomic) IBOutlet UITableView *repoListView;

- (IBAction)buttonPressed:(id)sender;

@end

